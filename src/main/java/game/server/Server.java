/*
 */
package game.server;

import game.client.Client;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author milton
 */
public interface Server extends Remote {

    public static final String DUPLICATED_NAME_ERROR = "Ese nombre ya fue usado por favor elija otro";
    public static String NOT_FOUND = "No se puede conectar con el servidor";

    String getName() throws RemoteException;

    List<Client> getClients() throws RemoteException;

    void register(Client client) throws RemoteException;

    void remove(Client client) throws RemoteException;

    int numberOfUserInDB() throws RemoteException;

    void sendMessageToAll(String message, String username) throws RemoteException;

    int numberOfMesagesInDB() throws RemoteException;
}
