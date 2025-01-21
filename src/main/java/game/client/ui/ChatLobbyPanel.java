/*
 */
package game.client.ui;

import game.server.Server;
import game.server.dto.MessageDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author milton
 */
public class ChatLobbyPanel extends JPanel{
    private ChatGroup chatGroup;
    private List<MessageDTO> messages;
    private JTextPane textPane;
            
    public ChatLobbyPanel() {
        messages = new ArrayList();
        
        this.initializeComponents();
    }
    
    private void initializeComponents(){
        textPane = new JTextPane();
        textPane.setEditable(true);
        textPane.setFont(new Font("Monospaced", Font.PLAIN, 14));
        AbstractDocument doc = (AbstractDocument)textPane.getDocument();
        ChatDocumentFilter documentFilter = new ChatDocumentFilter(textPane);
        doc.setDocumentFilter(documentFilter);
        this.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(textPane);
        this.add(scrollPane, BorderLayout.CENTER);
        textPane.setText("usuario1: hola\nusuario2: Como estas?\ntu: ");
        this.setPreferredSize(new Dimension(200,200));
    }
    public void initializeWith(Server server, String username) {
        chatGroup = new ChatToAllGroup(server, username);
    }

    public int getNumberOfMessages() {
        return messages.size();
    }

    public ChatGroup receiverGroup() {
        return chatGroup;
    }

    public void sendMessage(String message)  {
        try{
            chatGroup.send(message);
        }catch(Exception ex){
            this.receiveMessage(new MessageDTO(ex.getMessage()));
        }
    }

    public void receiveMessage(MessageDTO message) {
        messages.add(message);
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }    

    
    
}
