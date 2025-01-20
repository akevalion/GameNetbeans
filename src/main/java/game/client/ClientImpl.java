/*
 */
package game.client;

import game.server.dto.MessageDTO;
import game.server.dto.UserDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author milton
 */
public class ClientImpl extends UnicastRemoteObject implements Client {

    private String name;
    private Consumer<List<UserDTO>> whenUsersDo;
    private Consumer<MessageDTO> whenNewMessageDo;

    public ClientImpl(String name) throws RemoteException {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }

    public void whenUpdateUsersDo(Consumer<List<UserDTO>> con) {
        whenUsersDo = con;
    }

    @Override
    public void updateContectedUsers(List<UserDTO> users) throws RemoteException {
        if (whenUsersDo == null) {
            return;
        }

        whenUsersDo.accept(users);
    }

    public void whenNewMessageDo(Consumer<MessageDTO> con) {
        whenNewMessageDo = con;
    }

    @Override
    public void receiveMessage(MessageDTO messageDTO) throws RemoteException{
        if (whenNewMessageDo == null) {
            return;
        }
        whenNewMessageDo.accept(messageDTO);
    }

}
