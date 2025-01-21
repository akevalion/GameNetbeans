/*
 */
package game.server;

import game.client.Client;
import game.client.ClientImpl;
import org.junit.Test;
import static org.junit.Assert.*;
import static game.client.Client.*;
import game.server.db.Message;
import game.server.dto.MessageDTO;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

/**
 *
 * @author milton
 */
public class ServerTest {

    private Server server;

    @Before
    public void setUp() throws Exception {
        Server4Test server2Test = new Server4Test();
        server = server2Test;
    }

    @Test
    public void testGetServerName() throws Exception {
        String expResult = "Cacho";
        String result = server.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetEmptyClients() throws Exception {
        assertTrue(server.getClients().isEmpty());
    }

    @Test
    public void testAddClient() throws Exception {
        Client client = new ClientImpl(CLIENT_NAME1);
        server.register(client);
        assertFalse(server.getClients().isEmpty());
        assertEquals(server.getClients().get(0), client);
    }

    @Test
    public void testClientAddDuplicatedClientNameThrowsAnError() throws Exception {
        Client client1 = new ClientImpl(CLIENT_NAME1);
        Client client2 = new ClientImpl(CLIENT_NAME1);
        server.register(client1);
        try {
            server.register(client2);
            fail("should fail");
        } catch (Exception ex) {
            String expected = Server.DUPLICATED_NAME_ERROR;
            assertEquals(expected, ex.getMessage());
        }
    }

    @Test
    public void testAddASecondClientReturnsTheList() throws Exception {
        int[] update = {0};
        ClientImpl client1 = new ClientImpl(CLIENT_NAME1);
        client1.whenUpdateUsersDo((users) -> {
            update[0]++;
        });
        ClientImpl client2 = new ClientImpl(CLIENT_NAME2);
        client2.whenUpdateUsersDo((users) -> {
            update[0]++;
        });
        server.register(client1);
        int expected = 1;
        assertEquals(expected, update[0]);
        server.register(client2);
        expected = 3;
        assertEquals(expected, update[0]);
    }

    @Test
    public void testRemoveClient() throws Exception {
        Client client = new ClientImpl(CLIENT_NAME1);
        server.register(client);
        server.remove(client);
        assertTrue(server.getClients().isEmpty());
    }

    @Test
    public void testRemoteActivateUsersDo() throws Exception {
        ClientImpl client1 = new ClientImpl(CLIENT_NAME1);

        Client client2 = new ClientImpl(CLIENT_NAME2);
        server.register(client1);
        server.register(client2);
        int[] result = {0};
        client1.whenUpdateUsersDo((users) -> {
            result[0]++;
        });
        server.remove(client2);
        int expected = 1;
        assertEquals(expected, result[0]);
    }

    @Test
    public void testNumberOfUserInDB() throws Exception {
        int result = server.numberOfUserInDB();
        int expected = 0;
        assertEquals(expected, result);
    }

    @Test
    public void testAddUserModifiesDB() throws Exception {
        Client client = new ClientImpl(CLIENT_NAME1);
        server.register(client);
        int result = server.numberOfUserInDB();
        int expected = 1;
        assertEquals(expected, result);
    }
    
    @Test
    public void testNumberOfMessagesInDB() throws Exception{
        int result = server.numberOfMesagesInDB();
        int expected = 0;
        assertEquals(expected, result);
    }
    
    @Test
    public void testSendMessageToAll() throws Exception {
        Client client = new ClientImpl(CLIENT_NAME1);
        server.register(client);
        server.sendMessageToAll(Message.HI, CLIENT_NAME1);
        int result = server.numberOfMesagesInDB();
        int expected = 1;
        assertEquals(expected, result);
    }
    
    @Test
    public void testSendMessageToUsers() throws Exception{
        ClientImpl client1 = new ClientImpl(CLIENT_NAME1);
        ClientImpl client2 = new ClientImpl(CLIENT_NAME2);
        server.register(client1);
        server.register(client2);
        List<MessageDTO> list1 = new ArrayList();
        List<MessageDTO> list2 = new ArrayList();
        client1.whenNewMessageDo(list1::add);
        client2.whenNewMessageDo(list2::add);
        assertTrue(list1.isEmpty());
        assertTrue(list2.isEmpty());
        assertEquals(list1, list2);
        server.sendMessageToAll(Message.HI, CLIENT_NAME1);
        assertFalse(list1.isEmpty());
        assertFalse(list2.isEmpty());
        assertEquals(list1, list2);
    }
    
    private void prepareForLogin(List<MessageDTO> list1, List<MessageDTO> list2) throws Exception{
        ClientImpl client1 = new ClientImpl(CLIENT_NAME1);
        ClientImpl client2 = new ClientImpl(CLIENT_NAME2);
        client1.whenNewMessageDo(list1::add);
        client2.whenNewMessageDo(list2::add);
        server.register(client1);
        server.register(client2);
    }
    
    @Test
    public void testLoginSendsTwoMessagesToFirstClient() throws Exception{
        ArrayList<MessageDTO> list1 = new ArrayList();
        ArrayList<MessageDTO> list2 = new ArrayList();
        this.prepareForLogin(list1, list2);
        
        int result = list1.size();
        int expected = 2;
        assertEquals(expected, result);
    }
    
    @Test
    public void testLoginSendsAMessageToSecondClient() throws Exception{
        ArrayList<MessageDTO> list1 = new ArrayList();
        ArrayList<MessageDTO> list2 = new ArrayList();
        this.prepareForLogin(list1, list2);
        
        int result = list2.size();
        int expected = 1;
        assertEquals(expected, result);
    }
    
    @Test
    public void testLoginSendsWelcomeMessageToClients() throws Exception{
        ArrayList<MessageDTO> list1 = new ArrayList();
        ArrayList<MessageDTO> list2 = new ArrayList();
        this.prepareForLogin(list1, list2);
        
        String expected = ((ServerImpl)server).welcomeMessage(CLIENT_NAME1);
        String result = list1.get(0).getMessage();
        assertEquals(expected, result);
        
        expected = ((ServerImpl)server).welcomeMessage(CLIENT_NAME2);
        result = list2.get(0).getMessage();
        assertEquals(expected, result);
    }
    
    @Test
    public void testLoginAnnouncesNewClientToUsers() throws Exception{
        ArrayList<MessageDTO> list1 = new ArrayList();
        ArrayList<MessageDTO> list2 = new ArrayList();
        this.prepareForLogin(list1, list2);
        
        String expected = ((ServerImpl)server).hasConnectedMessage(CLIENT_NAME2);
        String result = list1.get(1).getMessage();
        assertEquals(expected, result);
    }
    
    @Test
    public void testLogoutAnnouncesInTheChat() throws Exception{
        ArrayList<MessageDTO> list1 = new ArrayList();
        ArrayList<MessageDTO> list2 = new ArrayList();
        this.prepareForLogin(list1, list2);
        server.remove(server.getClients().get(0));
        String expected = ((ServerImpl)server).hasDisconnectedMessage(CLIENT_NAME1);
        String result = list2.get(list2.size()-1).getMessage();
        assertEquals(expected, result);
    }
    
    @Test
    public void testLoginAnnouncesDoesNotCreateMessagesInDB() throws Exception{
        ArrayList<MessageDTO> list1 = new ArrayList();
        ArrayList<MessageDTO> list2 = new ArrayList();
        this.prepareForLogin(list1, list2);
        
        int result = server.numberOfMesagesInDB();
        int expected = 0;
        assertEquals(expected, result);
    }
}
