/*
 */
package game.server.calc;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

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
    
    @Test
    public void testSecondShoot(){
        int[] dice = {1, 1, 6, 6, 2};
        int expResult = 40;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    @Test
    public void testSecondShoot1(){
        int[] dice = {1, 1, 1, 1, 1};
        int expResult = 40;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    @Test
    public void testSecondShoot2(){
        int[] dice = {6, 1, 6, 6, 2};
        int expResult = 40;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    @Test
    public void testSecondShoot3(){
        int[] dice = {6, 6, 6, 6, 1};
        int expResult = 40;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
    @Test
    public void testSecondShoot4(){
        int[] dice = {4, 4, 4, 1, 4};
        int expResult = 40;
        int result = instance.secondShoot(dice);
        assertEquals(expResult, result);
    }
}
