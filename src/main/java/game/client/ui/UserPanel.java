/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game.client.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserPanel extends JPanel implements ActionListener {

    public static final String LOGOUT_TEXT = "Cerrar sesion";
    private ClientWindow window;
    private JLabel user;
    private JButton logoutButton;

    public UserPanel(ClientWindow window) throws Exception {
        this.window = window;

        this.setLayout(new BorderLayout());
        JPanel userDiv = new JPanel();
        JLabel label = new JLabel("Bienvenido");
        user = new JLabel(window.getClientImpl().getName());
        user.setFont(label.getFont().deriveFont(Font.BOLD));
        userDiv.add(label);
        userDiv.add(user);

        logoutButton = new JButton(LOGOUT_TEXT);
        logoutButton.addActionListener(this);
        userDiv.add(logoutButton);

        this.add(userDiv, BorderLayout.EAST);
    }

    public String getUserName() {
        return user.getText();
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        window.doLogout();
    }
    
}
