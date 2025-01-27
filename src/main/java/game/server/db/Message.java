/*
 */
package game.server.db;

import game.server.dto.MessageDTO;
import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author milton
 */
@Entity
@Table(name = "messages")
public class Message {

    public static final String HI = "hola!";
    public static final String WELCOME = "Bienvenido ";
    public static final String HAS_CONNECTED = " se ha conectado.";
    public static final String HAS_DISCONNECTED= " se ha desconectado.";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    public Message() {}

    public Message(String message, User user) {
        this(message, user, new Date());
        this.message = message;
        this.user = user;
    }
    
    public Message(String message, User user, Date date){
    }
    

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public MessageDTO asDTO() {
        MessageDTO dto = new MessageDTO();
        dto.setCreatedAt(createdAt);
        dto.setUsername(user.getName());
        dto.setMessage(message);
        return dto;
    }
}
