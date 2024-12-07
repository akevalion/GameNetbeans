/*
 */
package game;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author milton
 */
public interface Server extends Remote{
    List<String> getUserNames() throws RemoteException;
}
