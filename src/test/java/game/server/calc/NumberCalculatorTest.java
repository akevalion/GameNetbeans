
package game.server.calc;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pi
 */
public class NumberCalculatorTest {

    @Test
    public void testFirstShoot() {
        int[] dice = {2, 2, 4, 4, 4};
        NumberCalculator instance = new NumberCalculator(1);
        int expResult = 0;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstShoot1() {
        int[] dice = {2, 2, 4, 1, 4};
        NumberCalculator instance = new NumberCalculator(1);
        int expResult = 1;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
    @Test
    public void testFirstShoot2() {
        int[] dice = {2, 6, 6, 1, 6};
        NumberCalculator instance = new NumberCalculator(6);
        int expResult = 18;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }

    @Test
    public void testSecondShoot() {
        int[] dice = {2, 4, 4, 4, 5};
        NumberCalculator instance = new NumberCalculator(1);
        int expResult = 0;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot1() {
        int[] dice = {2, 2, 4, 4, 6};
        NumberCalculator instance = new NumberCalculator(2);
        int expResult = 4;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot2() {
        int[] dice = {2, 2, 4, 4, 5};
        NumberCalculator instance = new NumberCalculator(2);
        int expResult = 6;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot3() {
        int[] dice = {5, 5, 4, 4, 6};
        NumberCalculator instance = new NumberCalculator(2);
        int expResult = 4;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot4() {
        int[] dice = {5, 5, 5, 4, 6};
        NumberCalculator instance = new NumberCalculator(2);
        int expResult = 4;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot5() {
        int[] dice = {2, 2, 2, 2, 6};
        NumberCalculator instance = new NumberCalculator(2);
        int expResult = 8;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot6() {
        int[] dice = {2, 2, 5, 2, 2};
        NumberCalculator instance = new NumberCalculator(2);
        int expResult = 10;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot7() {
        int[] dice = {2, 2, 2, 2, 2};
        NumberCalculator instance = new NumberCalculator(2);
        int expResult = 8;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
}
