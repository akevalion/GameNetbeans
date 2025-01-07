/*
 */
package game.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author milton
 */
public class ClientImpl extends UnicastRemoteObject implements Client{
    private String name;
    private Consumer usersDo;
    
    public ClientImpl(String name) throws RemoteException{
        this.name = name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    @Override
    public String getName() throws RemoteException {
        return name;
    }

    public void usersDo(Consumer<List<Client>> con) throws RemoteException {
        usersDo = con;
    }

    @Override
    public void updateClients(List<Client> users) throws RemoteException {
        if(usersDo == null) return;
        usersDo.accept(users);
    }
    
    
}
