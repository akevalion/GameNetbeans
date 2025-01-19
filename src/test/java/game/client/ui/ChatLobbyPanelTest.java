/*
 */
package game.client.ui;

import game.client.LobbyPageTest;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author milton
 */
public class ChatLobbyPanelTest extends LobbyPageTest{
    private ChatLobbyPanel chatPanel;
    
    @Before
    @Override
    public void setUp() {
        super.setUp();
        chatPanel = lobby.getChatPanel();
    }
    
    @Test
    public void testLoadMessage(){
        int result = chatPanel.getNumberOfMessages();
        int expected = 0;
        assertEquals(expected, result);
    }
    
    @Test
    public void testGroupToSend(){
        assertTrue(chatPanel.receiverGroup().isToAll());
    }
    
    @Test
    public void testSendMessage(){
        chatPanel.sendMessage("123");
        int result = chatPanel.getNumberOfMessages();
        int expected = 1;
        assertEquals(expected, result);
    }
}
