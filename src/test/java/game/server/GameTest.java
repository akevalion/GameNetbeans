/*
 */
package game.server;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author milton
 */
public class GameTest {
    @Test
    public void testGetTables() {
        Game instance = new Game();
        boolean expResult = true;
        for(TableUser x : instance.getTables()){
            boolean result = x.isEmpty();
            assertEquals(expResult, result);
        }
    }

    @Test
    public void testGetCurrentTable() {
        Game game = new Game();
        TableUser expResult = game.getTables()[0];
        TableUser result = game.getCurrentTable();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetCurrentTable() {
        Game game = new Game(2);
        game.next();
        TableUser expResult = game.getTables()[1];
        TableUser result = game.getCurrentTable();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetDiceLenght() {
        int n = 10;
        while(n --> 0){
            int expResult = 5;
            int result = Game.getDice().length;
            assertEquals(expResult, result);
        }
    }
    @Test
    public void testGetDiceValues() {
        int n = 10;
        while(n --> 0){
            int [] dice = Game.getDice();
            for(int x: dice)
                assertTrue(x >= 1 && x <= 6);
        }
    }
}
