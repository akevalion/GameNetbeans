
package game.server.calc;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pi
 */
public class StairsCalculatorTest {
    
    @Test
    public void testFirstShoot() {
        int[] dice = {1, 1, 1, 2, 2};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 0;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstShoot1() {
        int[] dice = {1, 2, 3, 4, 5};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 25;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstShoot2() {
        int[] dice = {5, 4, 3, 2, 1};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 25;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void testFirstShoot3() {
        int[] dice = {2, 3, 4, 5, 6};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 25;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstShoot4() {
        int[] dice = {6, 5, 3, 4, 2};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 25;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstShoot6() {
        int[] dice = {1, 3, 4, 5, 6};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 25;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstShoot7() {
        int[] dice = {6, 3, 4, 1, 5};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 25;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
    /*
    @Test
    public void testSecondShoot() {
        System.out.println("secondShoot");
        int[] dice = null;
        int index = 0;
        StairsCalculator instance = new StairsCalculator();
        int expResult = 0;
        int result = instance.secondShoot(dice, index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
