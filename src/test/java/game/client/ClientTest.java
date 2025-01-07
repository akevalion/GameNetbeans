/*
 */
package game.client;

import org.junit.Test;
import static org.junit.Assert.*;
import static game.client.Client.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author milton
 */
public class ClientTest {
    
    @Test
    public void testGetName() throws Exception {
        String expResult = "Claudia";
        Client instance = new ClientImpl(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdateList() throws Exception{
        ClientImpl client = new ClientImpl(CLIENT_NAME1);
        List<Client> result = new ArrayList();
        client.usersDo((users)->{
            result.addAll(users);
        });
        List<Client> expected = new ArrayList();
        expected.add(new ClientImpl(CLIENT_NAME2));
        expected.add(new ClientImpl(CLIENT_NAME3));
        
        client.updateClients(expected);
        
        assertEquals(expected, result);
    }
}
