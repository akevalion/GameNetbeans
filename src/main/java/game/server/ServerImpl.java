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
    private List<Client> clients;
    private List<User> users;

    public ServerImpl() throws RemoteException {
        super();
        this.setUpDB();
        userRepository = new UserRepository(entityManager);
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

    public List<String> getUserNames() throws RemoteException {
        List<User> users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        List<String> names = new ArrayList();
        for (User x : users) {
            names.add(x.getName());
        }
        return names;
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

        if (!userRepository.userExists(name)) {
            userRepository.addUser(new User(name));
        }

        users.add(new User(name));
        clients.add(client);
        for (Client x : clients) {
            x.updateContectedUsers(users);
        }

    }

    @Override
    public synchronized void remove(Client client) throws RemoteException {
        clients.remove(client);
        users.clear();
        for (Client x : clients) {
            users.add(new User(x.getName()));
        }
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
    public int numberOfUserInDB() throws RemoteException {
        return userRepository.size();
    }

}
