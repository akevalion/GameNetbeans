/*
 */
package game.client;

import java.util.List;

/**
 *
 * @author milton
 */
public class LobbyPage extends Page {

    @Override
    public void install() {
        
    }

    public void updateUsers(List<Client> users) {
        System.out.println(users);
    }
    
}
