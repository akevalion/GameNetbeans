/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.server.dto;

/**
 *
 * @author pi
 */
import java.io.Serializable;
import java.util.Date;

public class MessageDTO implements Serializable {

    private static long serialVersionUID = 1L;
    private String message;
    private Date createdAt;
    private String username;

    public MessageDTO(){
        createdAt = new Date();
    }
    
    public MessageDTO(String message){
        this(message, null);
    }
    
    public MessageDTO(String message, String username) {
        this.message = message;
        this.username = username;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if(username != null){
            builder.append(username);
            builder.append(": ");
        }
        builder.append(message);
        return builder.toString();
    }

    
}
