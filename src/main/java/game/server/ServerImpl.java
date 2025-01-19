/*
 */
package game.server;

import game.client.Client;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author milton
 */
public class ServerImpl extends UnicastRemoteObject implements Server {

    protected EntityManager entityManager;
    private final UserRepository userRepository;
    private final MessageRepository messagesRepository;
    private List<Client> clients;
    private List<User> users;

    public ServerImpl() throws RemoteException {
        super();
        this.setUpDB();
        userRepository = new UserRepository(entityManager);
        messagesRepository = new MessageRepository(entityManager);
    }

    public void setUpDB() {
        this.createEntityManager("GamePU");
    }

    protected void createEntityManager(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(name);
        entityManager = emf.createEntityManager();
        clients = new ArrayList();
        users = new ArrayList();
    }

    @Override
    public String getName() throws RemoteException {
        return "Cacho";
    }

    @Override
    public synchronized List<Client> getClients() throws RemoteException {
        return clients;
    }

    @Override
    public synchronized void register(Client client) throws RemoteException {
        String name = client.getName();
        
        if (this.hasClient(name)) {
            throw new RemoteException(DUPLICATED_NAME_ERROR);
        }
        
        User user = userRepository.userNamed(name);
        if (user == null) {
            user = new User(name);
            userRepository.addUser(user);
        }
        users.add(user);
        clients.add(client);
        clients.forEach((x)->{
            try {
                x.updateContectedUsers(users);
            } catch (RemoteException ex) {}
        });
    }

    @Override
    public synchronized void remove(Client client) throws RemoteException {
        clients.remove(client);
        users.clear();
        
        clients.forEach((x) -> {
            try {
                users.add(new User(x.getName()));
            } catch (RemoteException ex) {}
        });
        
        for (Client x : clients) {
            x.updateContectedUsers(users);
        }
    }

    private boolean hasClient(String name) throws RemoteException {
        return this.getUserFor(name) != null;
    }

    private User getUserFor(String name) throws RemoteException {
        for (User x : users) {
            if (x.getName().equals(name)) {
                return x;
            }
        }
        return null;
    }

    @Override
    public synchronized int numberOfUserInDB() throws RemoteException {
        return userRepository.size();
    }

    @Override
    public synchronized void sendMessageToAll(String message, String username) throws RemoteException {
        Message aMessage = new Message(message, this.getUserFor(username));
        messagesRepository.addMessage(aMessage);
    }

    @Override
    public int numberOfMesagesInDB() throws RemoteException {
        return messagesRepository.numberOfMessages();
    }
}
