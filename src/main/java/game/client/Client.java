/*
 */
package game.client;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author milton
 */
public interface Client extends Remote{
    public final String CLIENT_NAME1 = "foo";
    public final String CLIENT_NAME2 = "bar";
    public final String CLIENT_NAME3 = "zorg";
    
    String getName() throws RemoteException;
    
    void updateClients(List<Client> users) throws RemoteException;
}
