/*
 */
package game.client;

import game.server.Server;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.rmi.Naming;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author milton
 */
public class ClientWindow extends JFrame {

    public static final String NAME = "Cacho";

    private Page currentPage;
    private Server server;
    private ClientImpl client;

    public ClientWindow() {
        super(NAME);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize();
        this.setPage(new LoginPage());
    }

    private void setSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        int frameWidth = (int) (screenWidth * 0.6);
        int frameHeight = (int) (screenHeight * 0.6);

        this.setSize(frameWidth, frameHeight);

        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;

        this.setLocation(x, y);
    }

    public void open() {
        this.setVisible(true);
    }

    public void close() {
        this.setVisible(false);
    }

    public void setPage(Page newPage) {
        currentPage = newPage;
        currentPage.setWindow(this);
        newPage.install();
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Server getServer() {
        return server;
    }

    public void setClient(Client client) {
        this.client = (ClientImpl) client;
    }

    public Server connectToServer() {
        try {
            Server service = (Server) Naming.lookup("rmi://localhost/Server");
            return service;
        } catch (Exception ex) {
            throw new RuntimeException(Server.NOT_FOUND);
        }
    }

    public void doLogin() throws Exception {
        if (server == null) {
            server = this.connectToServer();
        }
        if (client == null) {
            throw new Exception("should not happen");
        }
        LobbyPage lobby = new LobbyPage();
        client.usersDo((users) -> {
            lobby.updateUsers(users);
        });
        server.add(client);
        this.setPage(lobby);
    }

    public void clean() {
        this.getRootPane().removeAll();
    }
}
