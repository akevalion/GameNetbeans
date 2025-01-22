/*
 */
package game.client.ui;

import game.server.Server;

/**
 *
 * @author milton
 */
public class ChatToAllGroup extends ChatGroup {

    public ChatToAllGroup(String username) {
        this.setUsername(username);
    }

    @Override
    public void send(String message) throws Exception{
        server.sendMessageToAll(message, username);
    }

    @Override
    public boolean isToAll(){
        return true;
    }
}
