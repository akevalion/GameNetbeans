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
public class ServerImpl extends UnicastRemoteObject implements Server{
    private EntityManager entityManager;
    private List<Client> clients;
    public ServerImpl() throws RemoteException {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GamePU");
        entityManager = emf.createEntityManager();
        clients = new ArrayList();
    }

    public List<String> getUserNames() throws RemoteException {
        List<User> users = entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        List<String> names = new ArrayList();
        for(User x: users)
            names.add(x.getName());
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
    public synchronized void add(Client client) throws RemoteException {
        if(this.hasClient(client))
            throw new RemoteException(DUPLICATED_NAME_ERROR);
        clients.add(client);
        for(Client x : clients)
            x.updateClients(clients);
    }

    @Override
    public synchronized void remove(Client client) throws RemoteException {
        clients.remove(client);
        for(Client x : clients)
            x.updateClients(clients);
    }

    private boolean hasClient(Client client) throws RemoteException{
        String name = client.getName();
        for(Client x: clients)
            if(x.getName().equals(name))
                return true;
        return false;
    }
    
}
