/*
 */
package game.client;

import game.client.ui.ClientWindow;
import java.awt.Dimension;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author milton
 */
public class ClientWindowTest {
    private ClientWindow window;
    
    @Before
    public void setUp() {
        window = new ClientWindow();
        window.open();
    }
    
    @After
    public void tearDown() {
        window.close();
    }

    @Test
    public void testIsVisible() {
        assertTrue(window.isVisible());
    }
    
    @Test
    public void testTitle(){
        String expected = ClientWindow.NAME;
        String result = window.getTitle();
        assertEquals(expected, result);
    }
    
    @Test
    public void testExtent(){
        Dimension result = window.getSize();
        assertTrue(result.width > 100);
        assertTrue(result.height > 100);
    }
    
    @Test
    public void testFirstPage(){
        assertTrue(window.getCurrentPage().isLoginPage());
        assertTrue(window.getRootPane().getComponentCount() > 0);
        assertFalse(window.isResizable());
    }
    
    @Test
    public void testCleanWindow(){
        window.clean();
        int expected = 0;
        int result = window.getContentPane().getComponentCount();
        assertEquals(expected, result);
        assertTrue(window.isResizable());
    }
}
