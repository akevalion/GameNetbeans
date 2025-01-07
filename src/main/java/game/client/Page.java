/*
 */
package game.client;

/**
 *
 * @author milton
 */
public abstract class Page {

    protected ClientWindow window;

    public boolean isLoginPage() {
        return false;
    }

    public abstract void install();

    public ClientWindow getWindow() {
        return window;
    }

    public void setWindow(ClientWindow window) {
        this.window = window;
    }
}
