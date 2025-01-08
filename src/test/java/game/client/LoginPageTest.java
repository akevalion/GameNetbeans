/*
 */
package game.client;

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
        login.setName(Client.CLIENT_NAME1);
        login.loginToServer();
        assertFalse(window.getCurrentPage().isLoginPage());
    }

    @Test
    public void testLoginToServerWithInvalidName() {
        login.setName("");
        try {
            login.loginToServer();
            fail("should faild");
        } catch (Exception e) {
            String expected = LoginPage.INVALID_NAME_ERROR;
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    public void testLoginWithDuplicateName() {
        login.setName(Client.CLIENT_NAME1);
        login.loginToServer();

        ClientWindow anotherWindow = new ClientWindow();
        anotherWindow.setServer(server);
        LoginPage anotherLogin = (LoginPage) anotherWindow.getCurrentPage();
        anotherLogin.setName(Client.CLIENT_NAME1);

        try {
            anotherLogin.loginToServer();
            fail("should fail");
        } catch (Exception e) {
            String expected = Server.DUPLICATED_NAME_ERROR;
            assertEquals(expected, e.getMessage());
        }
    }
    
    @Test
    public void testLoginWhenServerIsDown() {
        login.setName(Client.CLIENT_NAME1);
        window.setServer(null);
        try{
            login.loginToServer();
            fail("should fail");
        }catch(Exception e){
            String expected = Server.NOT_FOUND;
            assertEquals(expected, e.getMessage());
        }
    }
    
}
