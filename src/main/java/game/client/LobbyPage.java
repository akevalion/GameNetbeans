/*
 */
package game.client;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author milton
 */
public class LobbyPage extends Page {

    private UserPanel userPanel;

    @Override
    public void install() throws Exception {
        JPanel lobbyPanel = new JPanel();
        lobbyPanel.setLayout(new BorderLayout());
        userPanel = new UserPanel(window);
        lobbyPanel.add(userPanel, BorderLayout.NORTH);
        window.setContentPane(lobbyPanel);
        window.revalidate();
    }

    @Override
    public boolean isLobbyPage() {
        return true;
    }

    public UserPanel getUserPanel() {
        return userPanel;
    }

    public void updateUsers(List<Client> users) {
        System.out.println(users);
    }

}
