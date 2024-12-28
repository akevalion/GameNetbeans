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
public class BigCalculatorTest {
    private BigCalculator instance;
    
    @Before
    public void setUp() {
        instance = new BigCalculator();
    }
    
    @Test
    public void testFirstShoot() {
        int[] dice = {1, 2, 3, 4, 5};
        int expResult = 0;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstShoot1() {
        int[] dice = {1, 1, 1, 1, 6};
        int expResult = 0;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFirstShoot2() {
        int[] dice = {1, 6, 1, 1, 6};
        int expResult = 0;
        int result = instance.firstShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot() {
        int[] dice = {1, 1, 1, 1, 6};
        int expResult = 50;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot1() {
        int[] dice = {1, 6, 1, 1, 6};
        int expResult = 50;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot2() {
        int[] dice = {6, 6, 6, 6, 6};
        int expResult = 0;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot3() {
        int[] dice = {1, 6, 4, 5, 6};
        int expResult = 0;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSecondShoot4() {
        int[] dice = {4, 4, 4, 4, 3};
        int expResult = 50;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    @Test
    public void testSecondShoot5() {
        int[] dice = {4, 4, 4, 5, 5};
        int expResult = 0;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
}
