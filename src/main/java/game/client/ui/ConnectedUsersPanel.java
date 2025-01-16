/*
 */
package game.client.ui;

import game.server.User;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

/**
 *
 * @author milton
 */
public class ConnectedUsersPanel extends JPanel {

    public static final String LIST_TITLE = "Jugadores Conectados";
    private final DefaultListModel<String> usersListModel;
    private final JList<String> userList;

    public ConnectedUsersPanel() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(150, 200));

        TitledBorder titleBorder = BorderFactory.createTitledBorder(ConnectedUsersPanel.LIST_TITLE);
        this.setBorder(titleBorder);

        usersListModel = new DefaultListModel<String>();
        userList = new JList<String>(usersListModel);

        JScrollPane scrollPane = new JScrollPane(userList);
        scrollPane.setPreferredSize(new Dimension(130, 170));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        this.add(scrollPane, BorderLayout.CENTER);
    }

    public void updateUsers(List<User> users) {
        usersListModel.clear();

        for (User user : users) {
            usersListModel.addElement(user.getName());
        }

    }

    public int getNumberOfUsers() {
        return usersListModel.getSize();
    }

}
