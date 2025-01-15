/*
 */
package game.client;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author milton
 */
public class ConnectedUsersPanel extends JPanel{

    public ConnectedUsersPanel() {
        this.setBackground(Color.blue);
        this.setPreferredSize(new Dimension(100,100));
    }

    public void updateUsers(List<Client> users) {
        System.out.print(users);
    }
    
}
