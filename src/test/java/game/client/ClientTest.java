/*
 */
package game.client;

import org.junit.Test;
import static org.junit.Assert.*;
import static game.client.Client.*;
import game.server.User;
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
        List<User> result = new ArrayList();
        client.usersDo((users)->{
            result.addAll(users);
        });
        List<User> expected = new ArrayList();
        expected.add(new User(CLIENT_NAME2));
        expected.add(new User(CLIENT_NAME3));
        
        client.updateContectedUsers(expected);
        
        assertEquals(expected, result);
    }
}
