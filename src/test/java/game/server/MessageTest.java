/*
 */
package game.server;

import game.client.Client;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author milton
 */
public class MessageTest {
    
    @Test
    public void testDefault() {
        Message m = new Message();
        Date result = m.getCreatedAt();
        Date expected = new Date();
        assertEquals(expected, result);
    }
    
    @Test
    public void testCreateMessage(){
        User user = new User(Client.CLIENT_NAME1);
        String expected = "hi";
        Message m = new Message(expected, user);
        String result = m.getMessage();
        assertEquals(expected, result);
    }
}
