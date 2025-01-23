/*
 */
package game.client.ui;

import static game.client.ui.ChatLobbyPanel.*;
import game.server.Server;
import game.server.dto.MessageDTO;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

/**
 *
 * @author milton
 */
public abstract class ChatGroup {

    protected Server server;
    protected String username;

    private final Color[] userColors = {
        new Color(74, 144, 226), // Azul Suave (#4A90E2)
        new Color(80, 227, 194), // Verde Lima (#50E3C2)
        new Color(245, 166, 35), // Naranja Claro (#F5A623)
        new Color(189, 16, 224), // Púrpura Pastel (#BD10E0)
        new Color(74, 74, 74) // Gris Oscuro (#4A4A4A)
    };
    private final HashMap<String, Color> userColorMap;

    private final List<MessageDTO> messages;

    public ChatGroup() {
        messages = new ArrayList();
        userColorMap = new HashMap();
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

    private Color getColorForUser(String user) {
        if (userColorMap.containsKey(user)) {
            return userColorMap.get(user);
        }
        Color assignedColor = userColors[userColorMap.size() % userColors.length];
        userColorMap.put(user, assignedColor);
        return assignedColor;
    }

    public void updateText(JTextPane textPane) {
        StyledDocument doc = textPane.getStyledDocument();
        Style defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);

        Style timestampStyle = doc.addStyle("Timestamp", defaultStyle);
        StyleConstants.setForeground(timestampStyle, Color.GRAY);
        StyleConstants.setFontFamily(timestampStyle, "Arial");
        StyleConstants.setFontSize(timestampStyle, 10);

        Style systemStyle = doc.addStyle("System", defaultStyle);
        StyleConstants.setForeground(systemStyle, Color.BLUE);
        StyleConstants.setFontFamily(systemStyle, "Arial");
        StyleConstants.setFontSize(systemStyle, 14);

        try {
            doc.remove(0, doc.getLength());
            for (MessageDTO message : messages) {
                doc.insertString(doc.getLength(), message.getCreatedAtAsString() + " ", timestampStyle);
                if (message.isSystemMessage()) {
                    doc.insertString(doc.getLength(), message.getMessage() + "\n", systemStyle);
                } else {
                    String name = message.getUsername();
                    Style userStyle = this.getStyleFor(name, doc, defaultStyle);
                    if (name.equals(username)) {
                        name = ONLY_YOU;
                    }
                    doc.insertString(doc.getLength(), name + ": ", userStyle);
                    doc.insertString(doc.getLength(), message.getMessage() + "\n", null);
                }
            }
            doc.insertString(doc.getLength(), YOU, null);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    public void addMessage(MessageDTO message) {
        messages.add(message);
    }

    private Style getStyleFor(String name, StyledDocument doc, Style defaultStyle) {
        Style style = doc.addStyle(name, defaultStyle);
        StyleConstants.setForeground(style, this.getColorForUser(name));
        StyleConstants.setFontFamily(style, "Arial");
        StyleConstants.setFontSize(style, 13);
        return style;
    }

}
