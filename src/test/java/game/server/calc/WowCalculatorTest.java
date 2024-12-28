/*
 */
package game.server.calc;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author milton
 */
public class WowCalculatorTest {
    private WowCalculator instance;
    @Before
    public void setUp() {
        instance = new WowCalculator();
    }
    
    @Test
    public void testFistShoot() {
        int [] dice = {1, 2, 3, 4, 5};
        int expected = 0;
        int result = instance.firstShoot(dice);
        assertEquals(expected, result);
    }
    
    @Test
    public void testFistShoot1() {
        int [] dice = {1, 1, 1, 1, 1};
        int expected = Integer.MAX_VALUE;
        int result = instance.firstShoot(dice);
        assertEquals(expected, result);
    }
    
    @Test
    public void testSecondShoot() {
        int [] dice = {1, 2, 3, 4, 5};
        int expected = 0;
        int result = instance.firstShoot(dice);
        assertEquals(expected, result);
    }
    
    @Test
    public void testSecondShoot1() {
        int [] dice = {1, 1, 1, 1, 1};
        int expected = 0;
        int result = instance.secondShoot(dice);
        assertEquals(expected, result);
    }
}
