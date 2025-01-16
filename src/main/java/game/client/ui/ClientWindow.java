/*
 */
package game.client.ui;

import game.client.ClientImpl;
import game.server.Server;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.rmi.Naming;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    public ClientWindow(Server server){
        this();
        this.setServer(server);
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
        try {
            newPage.setWindow(this);
            this.clean();
            newPage.install();
            currentPage = newPage;
            this.revalidate();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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

    public ClientImpl getClientImpl() {
        return client;
    }

    public void setClient(ClientImpl client) {
        this.client = client;
    }

    public Server connectToServer() {
        try {
            Server service = (Server) Naming.lookup("rmi://localhost/Server");
            return service;
        } catch (Exception ex) {
            throw new RuntimeException(Server.NOT_FOUND);
        }
    }

    public void clean() {
        this.setContentPane(new JPanel());
        this.revalidate();
        this.repaint();
        this.setResizable(true);
    }

    public void doLogout() {
        try {
            server.remove(client);
            this.setPage(new LoginPage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void loginWith(String name) {
        LoginPage login = (LoginPage)this.getCurrentPage();
        login.setName(name);
        login.loginToServer();
    }
}
