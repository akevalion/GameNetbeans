/*
 */
package game.client;

import game.client.ui.LoginPage;
import game.client.ui.ClientWindow;
import game.server.Server;
import game.server.ServerImpl;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author milton
 */
public class LoginPageTest {

    private LoginPage login;
    private ClientWindow window;
    private ServerImpl server;

    @Before
    public void setUp() {
        login = new LoginPage();
        window = new ClientWindow();
        try {
            server = new ServerImpl();
            window.setServer(server);
            window.setPage(login);
        } catch (Exception e) {
        }
    }

    /**
     * Test of installOn method, of class LoginPage.
     */
    @Test
    public void testComponents() {
        assertEquals(login.getName(), "");
        assertEquals(login.getEnterButton().getText(), LoginPage.ENTER_BUTTON_TEXT);
    }

    @Test
    public void testLoginToServer() {
        window.loginWith(Client.CLIENT_NAME1);
        assertFalse(window.getCurrentPage().isLoginPage());
    }

    @Test
    public void testLoginToServerWithInvalidName() {

        try {
            window.loginWith("");
            fail("should faild");
        } catch (Exception e) {
            String expected = LoginPage.INVALID_NAME_ERROR;
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    public void testLoginWithDuplicateName() {
        window.loginWith(Client.CLIENT_NAME1);
        ClientWindow anotherWindow = new ClientWindow(server);
        try {
            anotherWindow.loginWith(Client.CLIENT_NAME1);
            fail("should fail");
        } catch (Exception e) {
            String expected = Server.DUPLICATED_NAME_ERROR;
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    public void testLoginWhenServerIsDown() {
        window.setServer(null);
        try {
            window.loginWith(Client.CLIENT_NAME1);
            fail("should fail");
        } catch (Exception e) {
            String expected = Server.NOT_FOUND;
            assertEquals(expected, e.getMessage());
        }
    }

}
