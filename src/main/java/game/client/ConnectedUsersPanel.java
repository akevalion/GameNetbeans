/*
 */
package game.client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public static final String LIST_TITLE = "Usuarios Conectados";
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

    public void updateUsers(List<Client> users) {
        usersListModel.clear();

        for (Client user : users) {
            try {
                usersListModel.addElement(user.getName());
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int getNumberOfUsers() {
        return usersListModel.getSize();
    }

}
