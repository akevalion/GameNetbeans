/*
 */
package game.server;

import game.server.dao.MessageRepository;
import game.server.db.Message;
import game.server.dao.UserRepository;
import game.server.db.User;
import game.client.Client;
import game.server.dto.MessageDTO;
import game.server.dto.UserDTO;
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
    private List<UserDTO> users;

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
        
        this.cast(new MessageDTO(this.hasConnectedMessage(name)));
        users.add(user.asDTO());
        client.receiveMessage(new MessageDTO(this.welcomeMessage(name)));
        clients.add(client);
        this.updateClients();
    }

    private void cast(MessageDTO message){
        clients.forEach((x)->{
            try {
                x.receiveMessage(message);
            } catch (RemoteException e) {}
        });
    }
    
    private void updateClients() {
        clients.forEach((x) -> {
            try {
                x.updateContectedUsers(users);
            } catch (RemoteException ex) {
            }
        });
    }

    @Override
    public synchronized void remove(Client client) throws RemoteException {
        clients.remove(client);
        users.clear();

        clients.forEach((x) -> {
            try {
                users.add(new UserDTO(x.getName()));
            } catch (RemoteException ex) {
            }
        });
        this.updateClients();
        this.cast(new MessageDTO(this.hasDisconnectedMessage(client.getName())));
    }

    private boolean hasClient(String name) throws RemoteException {
        return this.getUserFor(name) != null;
    }

    private UserDTO getUserFor(String name) throws RemoteException {
        for (UserDTO x : users) {
            if (x.getUsername().equals(name)) {
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
        User user = userRepository.userNamed(username);
        Message aMessage = new Message(message, user, this.newDate()) ;
        messagesRepository.addMessage(aMessage);
        this.cast(aMessage.asDTO());
    }

    @Override
    public int numberOfMesagesInDB() throws RemoteException {
        return messagesRepository.numberOfMessages();
    }

    public String welcomeMessage(String name) {
        return Message.WELCOME + name;
    }

    public String hasConnectedMessage(String name) {
        return name + Message.HAS_CONNECTED;
    }

    public String hasDisconnectedMessage(String name) {
        return name + Message.HAS_DISCONNECTED;
    }
}
