
package game.server.calc;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pi
 */
public class FullCalculatorTest {
    
    @Test
    public void testFirstShoot() {
        int[] dice = {2, 1, 2, 4, 5};
        FullCalculator instance = new FullCalculator();
        int expResult = 0;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }

    @Test
    public void testFirstShoot1() {
        int[] dice = {2, 5, 2, 5, 2};
        FullCalculator instance = new FullCalculator();
        int expResult = 35;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstShoot2() {
        int[] dice = {1, 3, 1, 1, 3};
        FullCalculator instance = new FullCalculator();
        int expResult = 35;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot() {
        int[] dice = {2, 2, 5, 1, 1};
        FullCalculator instance = new FullCalculator();
        int expResult = 30;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot1() {
        int[] dice = {3, 2, 5, 1, 1};
        FullCalculator instance = new FullCalculator();
        int expResult = 0;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot2() {
        int[] dice = {2, 4, 5, 3, 3};
        FullCalculator instance = new FullCalculator();
        int expResult = 30;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
}
