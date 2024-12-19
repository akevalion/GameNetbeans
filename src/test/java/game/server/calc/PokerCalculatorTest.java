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
public class PokerCalculatorTest {
    private PokerCalculator instance;
    
    @Before
    public void setUp() {
        instance = new PokerCalculator();
    }
   
    @Test
    public void testFirstShoot() {
        int[] dice = {2, 1, 2, 4, 5};
        int expResult = 0;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstShoot1() {
        int[] dice = {2, 2, 2, 2, 5};
        int expResult = 45;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstShoot2() {
        int[] dice = {1, 1, 3, 1, 1};
        int expResult = 45;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
}
