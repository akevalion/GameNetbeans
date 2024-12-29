/*
 */
package game.server;

import org.junit.Test;
import static org.junit.Assert.*;

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
    
}
