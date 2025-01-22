/*
 */
package game.client.ui;

import static game.client.ui.ChatLobbyPanel.YOU;
import game.server.Server;
import game.server.dto.MessageDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextPane;

/**
 *
 * @author milton
 */
public abstract class ChatGroup {

    protected Server server;
    protected String username;
    private List<MessageDTO> messages;

    public ChatGroup() {
        messages = new ArrayList();
    }

    public abstract void send(String meesage) throws Exception;

    public boolean isToAll() {
        return false;
    }

    public boolean isToGroup() {
        return false;
    }

    public boolean isToOneUser() {
        return false;
    }

    public Server getServer() {
        return server;
    }

    public String getUsername() {
        return username;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void updateText(JTextPane textPane) {
        StringBuilder builder = new StringBuilder();
        for (MessageDTO message : messages) {
            boolean flag = false;
            if (message.getUsername() != null && message.getUsername().equals(username)) {
                message.setUsername("tu");
                flag = true;
            }
            builder.append(message.toString());
            if (flag) {
                message.setUsername(username);
            }
            builder.append("\n");
        }
        builder.append(YOU);
        textPane.setText(builder.toString());
    }

    public void addMessage(MessageDTO message) {
        messages.add(message);
    }
}
