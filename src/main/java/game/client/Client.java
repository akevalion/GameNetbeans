/*
 */
package game.client;

import game.server.dto.MessageDTO;
import game.server.dto.UserDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author milton
 */
public interface Client extends Remote {

    public final String CLIENT_NAME1 = "foo";
    public final String CLIENT_NAME2 = "bar";
    public final String CLIENT_NAME3 = "zorg";

    String getName() throws RemoteException;

    void updateContectedUsers(List<UserDTO> users) throws RemoteException;

    void receiveMessage(MessageDTO messageDTO) throws RemoteException;
}
