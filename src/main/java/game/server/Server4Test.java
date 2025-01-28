/*
 */
package game.server;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityTransaction;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

/**
 *
 * @author milton
 */
public class Server4Test extends ServerImpl {

    private Date dateForTest;
    
    public Server4Test() throws RemoteException{
        this(new Date());
    }
            
    public Server4Test(Date dateForTest) throws RemoteException {
        super();
        this.dateForTest = dateForTest;
        this.clearDatabase();
    }

    @Override
    public void setUpDB() {
        this.createEntityManager("GameTestPU");
    }

    public void clearDatabase() {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            for (Class<?> entityClass : getAllEntityClasses()) {
                entityManager.createQuery("DELETE FROM " + entityClass.getSimpleName()).executeUpdate();
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    private List<Class<?>> getAllEntityClasses() {
        Metamodel metamodel = entityManager.getEntityManagerFactory().getMetamodel();
        return metamodel.getEntities().stream()
                .map(EntityType::getJavaType)
                .collect(Collectors.toList());
    }
    private Date newDate(){
        return dateForTest;
    }
}
