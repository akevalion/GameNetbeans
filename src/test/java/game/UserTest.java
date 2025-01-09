package game;

import game.server.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author milton
 */
public class UserTest {

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        User user = new User("foo");
        String expResult = null;
        String result = user.getName();
        assertEquals(expResult, result);
    }
}
