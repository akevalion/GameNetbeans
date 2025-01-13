/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package game.client;

import game.server.Server;
import game.server.Server4Test;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pi
 */
public class LobbyPageTest {
    private Server server;
    private ClientWindow window;
    private LobbyPage lobby;
    
    @Before
    public void setUp() {
        window = new ClientWindow();
        try {
            server = new Server4Test();
            window.setServer(server);
            LoginPage login = (LoginPage)window.getCurrentPage();
            login.setName(Client.CLIENT_NAME1);
            login.loginToServer();
            lobby = (LobbyPage)window.getCurrentPage();
        } catch (Exception e) {
        }
    }
    
    @Test
    public void testAfterLoginCurrentPageIsLobby(){
        assertTrue(lobby.isLobbyPage());
    }
    @Test
    public void testInstallCreatesAUserPanel() {
        UserPanel panel = lobby.getUserPanel();
        String expected = Client.CLIENT_NAME1;
        String result = panel.getUserName();
        assertEquals(expected, result);
    }
    
    @Test
    public void testInstallUserPanelHasALogoutButton(){
        String result = lobby.getUserPanel().getLogoutButton().getText();
        String expected = UserPanel.LOGOUT_TEXT;
        assertEquals(expected, result);
    }
    
    @Test
    public void testLogoutButtonRestoreLoginPage(){
        window.doLogout();
        Page page = window.getCurrentPage();
        
        assertFalse(page.isLobbyPage());
        assertTrue(page.isLoginPage());
    }

    @Test
    public void testUpdateUsers() {
    }
    
}
