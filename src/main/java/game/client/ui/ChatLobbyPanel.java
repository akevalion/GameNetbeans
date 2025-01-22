/*
 */
package game.client.ui;

import game.server.Server;
import game.server.dto.MessageDTO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author milton
 */
public class ChatLobbyPanel extends JPanel implements KeyListener {
    
    public static final String YOU = "tu: ";
    private ChatGroup chatGroup;
    private JTextPane textPane;
    private String username;
    
    public ChatLobbyPanel(String username) {
        this.username = username;
        chatGroup = new ChatToAllGroup(username);
        this.initializeComponents();
    }
    
    private void initializeComponents() {
        textPane = new JTextPane();
        textPane.addKeyListener(this);
        textPane.setEditable(true);
        textPane.setFont(new Font("Monospaced", Font.PLAIN, 14));
        AbstractDocument doc = (AbstractDocument) textPane.getDocument();
        ChatDocumentFilter documentFilter = new ChatDocumentFilter(textPane);
        doc.setDocumentFilter(documentFilter);
        this.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(textPane);
        this.add(scrollPane, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(200, 200));
    }
    
    public void initializeWith(Server server) {
        chatGroup.setServer(server);
    }
    
    public int getNumberOfMessages() {
        return this.getMessages().size();
    }
    
    public ChatGroup receiverGroup() {
        return chatGroup;
    }
    
    public void sendMessage(String message) {
        try {
            chatGroup.send(message);
        } catch (Exception ex) {
            this.receiveMessage(new MessageDTO(ex.getMessage()));
        }
    }
    
    public void receiveMessage(MessageDTO message) {
        chatGroup.addMessage(message);
        this.updateText();
    }
    
    public void updateText() {
        SwingUtilities.invokeLater(() -> chatGroup.updateText(textPane));
    }
    
    public List<MessageDTO> getMessages() {
        return chatGroup.getMessages();
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            e.consume();
            String text = this.getCurrentText();
            this.sendMessage(text);
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    private String getCurrentText() {
        String text = textPane.getText();
        int index = text.lastIndexOf("\n") + 1;
        return text.substring(index + YOU.length(), text.length());
    }
    
    public String getText() {
        return textPane.getText();
    }
    
}
