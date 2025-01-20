/*
 */
package game.client.ui;

import game.client.ClientImpl;
import game.server.Server;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author milton
 */
public class LoginPage extends Page implements ActionListener {

    public static final String ENTER_BUTTON_TEXT = "Entrar";
    public static final String INVALID_NAME_ERROR = "Ingresa un nombre valido";

    private JTextField nameField;
    private JButton enterButton;

    public LoginPage() {
        nameField = new JTextField(15);
        nameField.addActionListener(this);

        enterButton = new JButton(ENTER_BUTTON_TEXT);
        enterButton.addActionListener(this);
    }

    @Override
    public boolean isLoginPage() {
        return true;
    }

    @Override
    public void install() throws Exception {
        window.setResizable(false);
        // Configurar el layout principal
        window.setLayout(new GridBagLayout());

        // Fondo GIF
        JLabel backgroundLabel = new JLabel();

        // Ajustar la imagen al tamaño de la ventana
        ImageIcon backgroundImage = new ImageIcon("img/animated.gif");
        backgroundLabel.setIcon(new ImageIcon(backgroundImage.getImage().getScaledInstance(window.getWidth(), window.getHeight(), Image.SCALE_DEFAULT)));
        backgroundLabel.setLayout(new GridBagLayout()); // Para superponer componentes

        // Configurar restricciones para los paneles
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER; // Centrar en el espacio disponible
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado alrededor del panel

        // Panel central: entrada de nombre
        JPanel inputPanel = new TransparentPanel(new Color(200, 200, 200, 200));
        inputPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        inputPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 2), // Borde visible
                BorderFactory.createEmptyBorder(10, 10, 10, 10) // Padding interno
        ));
        // Tamaño fijo

        JLabel nameLabel = new JLabel("Ingresa tu nombre:");
        inputPanel.setPreferredSize(new Dimension(nameLabel.getPreferredSize().width+ 60 + enterButton.getPreferredSize().width+ nameField.getPreferredSize().width, 70));
        
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(enterButton);

        // Panel inferior: botón "Cambiar servidor"
        JPanel serverPanel = new JPanel();
        serverPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        //JButton changeServerButton = new JButton("Cambiar servidor");
        //serverPanel.add(changeServerButton);

        // Hacer ambos paneles transparentes para mostrar el fondo GIF
        inputPanel.setOpaque(false);
        serverPanel.setOpaque(false);

        // Agregar los paneles al fondo
        backgroundLabel.add(inputPanel, gbc);

        gbc.gridy = 1; // Colocar serverPanel debajo
        gbc.anchor = GridBagConstraints.PAGE_END; // Alinear al final
        backgroundLabel.add(serverPanel, gbc);

        // Agregar el fondo al JFrame
        window.setContentPane(backgroundLabel); // Establecer el fondo como contenido principal
        
        nameField.grabFocus();
    }

    public JButton getEnterButton() {
        return enterButton;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        try {
            this.loginToServer();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(window, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loginToServer() {
        String name = nameField.getText();
        if (name.trim().isEmpty()) {
            throw new RuntimeException(INVALID_NAME_ERROR);
        }
        try {
            window.setClient(new ClientImpl(name));
            this.doLogin();
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
    private void doLogin() throws Exception {
        Server server = window.getServer();
        ClientImpl client = window.getClientImpl();
        if (server == null) {
            server = window.connectToServer();
        }
        if (client == null) {
            throw new Exception("should not happen");
        }
        LobbyPage lobby = new LobbyPage();
        client.whenUpdateUsersDo((users) -> {
            lobby.updateUsers(users);
        });
        server.register(client);
        window.setServer(server);
        window.setPage(lobby);
    }

    public String getName() {
        return nameField.getText();
    }

    public void setName(String name) {
        nameField.setText(name);
    }
}
