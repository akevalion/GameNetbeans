/*
 */
package game.client.ui;

import game.server.User;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.*;

/**
 *
 * @author milton
 */
public class LobbyPage extends Page {

    private UserPanel userPanel;
    private final ConnectedUsersPanel connectedUsersPanel;
    private GamesPanel gamesPanel;
    private ChatLobbyPanel chatPanel;
    private FamePanel hallOfFame;

    public LobbyPage() {
        connectedUsersPanel = new ConnectedUsersPanel();
    }

    @Override
    public void install() throws Exception {
        JPanel lobbyPanel = new JPanel();
        lobbyPanel.setLayout(new BorderLayout());
        userPanel = new UserPanel(window);

        lobbyPanel.add(userPanel, BorderLayout.NORTH);
        lobbyPanel.add(connectedUsersPanel, BorderLayout.WEST);
        gamesPanel = new GamesPanel();
        lobbyPanel.add(gamesPanel, BorderLayout.CENTER);
        chatPanel = new ChatLobbyPanel(window.getServer(), window.getClientImpl().getName());
        lobbyPanel.add(chatPanel, BorderLayout.SOUTH);
        hallOfFame = new FamePanel();
        lobbyPanel.add(hallOfFame, BorderLayout.EAST);

        window.setContentPane(lobbyPanel);
    }

    @Override
    public boolean isLobbyPage() {
        return true;
    }

    public UserPanel getUserPanel() {
        return userPanel;
    }

    public void updateUsers(List<User> users) {
        connectedUsersPanel.updateUsers(users);
    }

    public int getNumberOfUsers() {
        return connectedUsersPanel.getNumberOfUsers();
    }

    public ChatLobbyPanel getChatPanel() {
        return chatPanel;
    }

}
