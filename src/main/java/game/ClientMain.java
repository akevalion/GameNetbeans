/*
 */
package game;

import game.client.ui.ClientWindow;
import javax.swing.UIManager;

/**
 *
 * @author milton
 */
public class ClientMain {
    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        new ClientWindow().open();
    }
}
