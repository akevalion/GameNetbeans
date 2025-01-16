/*
 */
package game.client.ui;

/**
 *
 * @author milton
 */
public abstract class Page {

    protected ClientWindow window;

    public boolean isLoginPage() {
        return false;
    }

    public boolean isLobbyPage() {
        return false;
    }

    public abstract void install() throws Exception;

    public ClientWindow getWindow() {
        return window;
    }

    public void setWindow(ClientWindow window) {
        this.window = window;
    }
}
