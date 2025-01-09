/*
 */
package game.server;

import java.rmi.RemoteException;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author milton
 */
public class Server4Test extends ServerImpl {

    public Server4Test() throws RemoteException {
        super();
    }

    @Override
    public void setUpDB() {
        this.createEntityManager("GameTestPU");
    }

    public void closeEntityManager() {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
        EntityManagerFactory emf = entityManager.getEntityManagerFactory();
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
