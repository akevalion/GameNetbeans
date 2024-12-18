
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
    
    @Test
    public void testSecondShoot() {
        int[] dice = {1, 2, 3, 4, 5};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 20;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot1() {
        int[] dice = {2, 3, 4, 5, 6};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 20;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot2() {
        int[] dice = {6, 3, 4, 5, 1};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 20;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot3() {
        int[] dice = {6, 3, 4, 3, 1};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 0;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot4() {
        int[] dice = {1, 3, 4, 5, 5};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 20;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot5() {
        int[] dice = {2, 4, 4, 5, 6};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 20;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot6() {
        int[] dice = {6, 3, 4, 5, 6};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 20;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot7() {
        int[] dice = {6, 3, 3, 5, 5};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 20;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot8() {
        int[] dice = {1, 4, 4, 5, 5};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 20;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot9() {
        int[] dice = {1, 4, 4, 2, 1};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 0;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot10() {
        int[] dice = {1, 4, 4, 5, 1};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 20;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot11() {
        int[] dice = {6, 4, 4, 2, 6};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 0;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot12() {
        int[] dice = {6, 3, 3, 2, 6};
        StairsCalculator instance = new StairsCalculator();
        int expResult = 0;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
}
