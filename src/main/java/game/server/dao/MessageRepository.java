/*
 */
package game.server.dao;

import game.server.db.Message;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author milton
 */
public class MessageRepository {

    private final EntityManager entityManager;
    public MessageRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public int numberOfMessages() {
        try {
            Long count = entityManager.createQuery("SELECT COUNT(m) FROM Message m", Long.class)
                    .getSingleResult();
            return count.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al contar los mensajes en la base de datos", e);
        }
    }

    public void addMessage(Message message) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(message);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw new RuntimeException("Error al guardar el mensaje en la base de datos", e);
        }
    }
    
    
}
