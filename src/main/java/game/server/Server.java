/*
 */
package game.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author milton
 */
public interface Server extends Remote{
    String getName() throws RemoteException;
}
