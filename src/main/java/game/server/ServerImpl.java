/*
 */
package game.server;

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
    public ServerImpl() throws RemoteException {
        super();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GamePU");
        entityManager = emf.createEntityManager();
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
    
}
