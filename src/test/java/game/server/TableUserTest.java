
package game.server;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author milton
 */
public class TableUserTest {
    
    @Test
    public void testCanPlay() {
        TableUser instance = new TableUser();
        
        boolean expResult = true;
        boolean result = instance.canPlay(Play.BALAS);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetPlay() {
        TableUser instance = new TableUser();
        instance.set(Play.BALAS, 1);
        boolean expResult = false;
        boolean result = instance.canPlay(Play.BALAS);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSum() {
        TableUser instance = new TableUser();
        instance.set(Play.CUADRAS, 4);
        instance.set(Play.POKER, 40);
        
        int expResult = 44;
        int result = instance.totalPoints();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToString() {
        TableUser instance = new TableUser();
        String expResult = String.join(System.lineSeparator(),
                "┌────┬────┬────┐",
                "│    │    │    │",
                "├────┼────┼────┤",
                "│    │    │    │",
                "├────┼────┼────┤",
                "│    │    │    │",
                "└────┼────┼────┘",
                "     │    │",
                "     ├────┤",
                "     │    │",
                "     └────┘"
        );
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testToStringNumbers() {
        TableUser instance = new TableUser();
        instance.set(Play.BALAS, 1);
        instance.set(Play.TONTOS, 2);
        instance.set(Play.TRENES, 3);
        instance.set(Play.CUADRAS, 4);
        instance.set(Play.QUINAS, 5);
        instance.set(Play.SENAS, 6);
        
        String expResult = String.join(System.lineSeparator(),
                "┌────┬────┬────┐",
                "│  1 │    │  4 │",
                "├────┼────┼────┤",
                "│  2 │    │  5 │",
                "├────┼────┼────┤",
                "│  3 │    │  6 │",
                "└────┼────┼────┘",
                "     │    │",
                "     ├────┤",
                "     │    │",
                "     └────┘"
        );
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    @Test
    public void testToStringBelly() {
        TableUser instance = new TableUser();
        instance.set(Play.ESCALERA, 20);
        instance.set(Play.FULL, 30);
        instance.set(Play.POKER, 40);
        instance.set(Play.GRANDE1, 50);
        instance.set(Play.GRANDE2, 50);
        
        String expResult = String.join(System.lineSeparator(),
                "┌────┬────┬────┐",
                "│    │ 20 │    │",
                "├────┼────┼────┤",
                "│    │ 30 │    │",
                "├────┼────┼────┤",
                "│    │ 40 │    │",
                "└────┼────┼────┘",
                "     │ 50 │",
                "     ├────┤",
                "     │ 50 │",
                "     └────┘"
        );
        String result = instance.toString();
        assertEquals(expResult, result);
    }
}
