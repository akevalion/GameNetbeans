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
        System.out.println("getName");
        User instance = new User();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }
}
