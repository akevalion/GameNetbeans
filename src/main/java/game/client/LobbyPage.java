/*
 */
package game.client;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author milton
 */
public class LobbyPage extends Page {
/*
    private JTable userTable;
    private JTable gameTable;
    private JTable hallOfFameTable;
    private JButton createGameButton;
    private JButton logoutButton;
    private JLabel userName;

    public LobbyPage() {
        setLayout(new GridBagLayout());
        setBackground(Color.LIGHT_GRAY);
    }
    
    @Override
    public void install() {
        // Configuración del layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        // Tabla de usuarios conectados
        String[] userColumns = {"Usuarios Conectados"};
        DefaultTableModel userModel = new DefaultTableModel(userColumns, 0);
        userTable = new JTable(userModel);
        JScrollPane userScrollPane = new JScrollPane(userTable);
        List<String> connectedUsers = getConnectedUsers();
        for (String user : connectedUsers) {
            userModel.addRow(new Object[]{user});
        }

        // Tabla de partidas activas
        String[] gameColumns = {"Sala", "Anfitrión", "Jugadores", "Estado"};
        DefaultTableModel gameModel = new DefaultTableModel(gameColumns, 0);
        gameTable = new JTable(gameModel);
        JScrollPane gameScrollPane = new JScrollPane(gameTable);
        List<Object[]> activeGames = getActiveGames();
        for (Object[] game : activeGames) {
            gameModel.addRow(game);
        }

        // Tabla del Salón de la Fama
        String[] fameColumns = {"Jugador", "Puntaje Máximo"};
        DefaultTableModel fameModel = new DefaultTableModel(fameColumns, 0);
        hallOfFameTable = new JTable(fameModel);
        JScrollPane fameScrollPane = new JScrollPane(hallOfFameTable);
        List<Object[]> hallOfFame = getHallOfFame();
        for (Object[] fameEntry : hallOfFame) {
            fameModel.addRow(fameEntry);
        }

        // Botón para crear una nueva partida
        createGameButton = new JButton("Crear Partida");
        createGameButton.addActionListener(e -> {
            System.out.println("Crear partida presionado");
        });

        // Añadir componentes al layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Usuarios Conectados"), gbc);

        gbc.gridy = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        add(userScrollPane, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(new JLabel("Partidas Activas"), gbc);

        gbc.gridy = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        add(gameScrollPane, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.weightx = 0;
        gbc.weighty = 0;
        add(new JLabel("Salón de la Fama"), gbc);

        gbc.gridy = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 1;
        add(fameScrollPane, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(createGameButton, gbc);

        // Configurar la ventana principal
        window.setContentPane(this);
    }

    private List<String> getConnectedUsers() {
        // Lista ficticia de usuarios conectados
        List<String> users = new ArrayList<>();
        users.add("Jugador1");
        users.add("Jugador2");
        users.add("Jugador3");
        users.add("Jugador4");
        return users;
    }

    private List<Object[]> getActiveGames() {
        // Lista ficticia de partidas activas
        List<Object[]> games = new ArrayList<>();
        games.add(new Object[]{"Sala 1", "Jugador1", "2/5", "Esperando"});
        games.add(new Object[]{"Sala 2", "Jugador3", "3/5", "En juego"});
        return games;
    }

    private List<Object[]> getHallOfFame() {
        // Lista ficticia del Salón de la Fama
        List<Object[]> hallOfFame = new ArrayList<>();
        hallOfFame.add(new Object[]{"Jugador1", 15000});
        hallOfFame.add(new Object[]{"Jugador2", 12000});
        hallOfFame.add(new Object[]{"Jugador3", 11000});
        hallOfFame.add(new Object[]{"Jugador4", 10000});
        return hallOfFame;
    }
*/
    @Override
    public void install() {
        
    }
    public void updateUsers(List<Client> users) {
        System.out.println(users);
    }
   
}
