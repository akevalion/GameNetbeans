/*
 */
package game.client.ui;

import game.client.LobbyPageTest;
import game.server.ServerImpl;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import game.server.db.Message;
import game.server.dto.MessageDTO;
import java.util.List;
import game.client.Client;

/**
 *
 * @author milton
 */
public class ChatLobbyPanelTest extends LobbyPageTest {

    private ChatLobbyPanel chatPanel;

    @Before
    @Override
    public void setUp() {
        super.setUp();
        chatPanel = lobby.getChatPanel();
    }

    @Test
    public void testFirstMessages() {
        int result = chatPanel.getNumberOfMessages();
        int expected = 1;
        assertEquals(expected, result);
    }

    @Test
    public void testGroupToSend() {
        assertTrue(chatPanel.receiverGroup().isToAll());
    }

    @Test
    public void testSendMessageAddsANewMessage() {
        chatPanel.sendMessage(Message.HI);
        int result = chatPanel.getNumberOfMessages();
        int expected = 2;
        assertEquals(expected, result);
    }

    @Test
    public void testSendMessageValues() {
        String expected = Message.HI;
        chatPanel.sendMessage(expected);
        List<MessageDTO> messages = chatPanel.getMessages();

        String result = messages.get(messages.size() - 1).getMessage();
        assertEquals(expected, result);
    }
    
    @Test
    public void testTextInChat(){
        String result = chatPanel.getText();
        String expected = ((ServerImpl)window.getServer()).welcomeMessage(Client.CLIENT_NAME1)+"\n"+ChatLobbyPanel.YOU;
        assertEquals(expected, result);
    }
}
