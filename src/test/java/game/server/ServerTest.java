/*
 */
package game.server;

import game.client.Client;
import game.client.ClientImpl;
import org.junit.Test;
import static org.junit.Assert.*;
import static game.client.Client.*;

/**
 *
 * @author milton
 */
public class ServerTest {
    
    @Test
    public void testGetServerName() throws Exception {
        Server server = new ServerImpl();
        String expResult = "Cacho";
        String result = server.getName();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetEmptyClients() throws Exception {
        Server server = new ServerImpl();
        assertTrue(server.getClients().isEmpty());
    }
    
    @Test
    public void testAddClient() throws Exception {
        Server server = new ServerImpl();
        Client client = new ClientImpl(CLIENT_NAME1);
        server.add(client);
        assertFalse(server.getClients().isEmpty());
        assertEquals(server.getClients().get(0), client);
    }
    
    @Test
    public void testClientAddDuplicatedClientNameThrowsAnError() throws Exception{
        Server server = new ServerImpl();
        Client client1 = new ClientImpl(CLIENT_NAME1);
        Client client2 = new ClientImpl(CLIENT_NAME1);
        server.add(client1);
        try{
            server.add(client2);
            fail("should fail");
        }catch(Exception ex){
            String expected = Server.DUPLICATED_NAME_ERROR;
            assertEquals(expected, ex.getMessage());
        }
    }
    
    @Test
    public void testAddASecondClientReturnsTheList() throws Exception{
        Server server = new ServerImpl();
        int [] update = {0};
        ClientImpl client1 = new ClientImpl(CLIENT_NAME1);
        client1.usersDo((users)->{
            update[0]++;
        });
        ClientImpl client2 = new ClientImpl(CLIENT_NAME2);
        client2.usersDo((users)->{
            update[0]++;
        });
        server.add(client1);
        int expected = 1;
        assertEquals(expected, update[0]);
        server.add(client2);
        expected = 3;
        assertEquals(expected, update[0]);
    }
    
    @Test
    public void testRemoveClient() throws Exception{
        Server server = new ServerImpl();
        Client client = new ClientImpl(CLIENT_NAME1);
        server.add(client);
        server.remove(client);
        assertTrue(server.getClients().isEmpty());
    }
    
    @Test
    public void testRemoteActivateUsersDo() throws Exception{
        Server server = new ServerImpl();
        ClientImpl client1 = new ClientImpl(CLIENT_NAME1);
        
        Client client2 = new ClientImpl(CLIENT_NAME2);
        server.add(client1);
        server.add(client2);
        int[] result = {0};
        client1.usersDo((users)->{
            result[0]++;
        });
        server.remove(client2);
        int expected = 1;
        assertEquals(expected, result[0]); 
    }
}
