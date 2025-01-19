/*
 */
package game.client.ui;

import game.server.Server;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author milton
 */
public class ChatLobbyPanel extends JPanel{
    private ChatGroup chatGroup;
            
    public ChatLobbyPanel(Server server, String username) {
        chatGroup = new ChatToAllGroup(server, username);
        this.setBackground(Color.green);
        this.setPreferredSize(new Dimension(200,200));
    }

    public int getNumberOfMessages() {
        return 0;
    }

    public ChatGroup receiverGroup() {
        return chatGroup;
    }

    public void sendMessage(String message)  {
        try{
            chatGroup.send(message);
        }catch(Exception ex){
            this.receiveMessage(ex.getMessage());
        }
    }

    public void receiveMessage(String message) {
        
    }
    
    
}
