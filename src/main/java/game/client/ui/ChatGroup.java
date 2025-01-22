/*
 */
package game.client.ui;

import game.server.Server;

/**
 *
 * @author milton
 */
public abstract class ChatGroup {

    protected Server server;
    protected String username;

    public ChatGroup(Server server, String username) {
        this.server = server;
        this.username = username;
    }

    public abstract void send(String meesage) throws Exception;

    public boolean isToAll() {
        return false;
    }

    public boolean isToGroup() {
        return false;
    }

    public boolean isToOneUser() {
        return false;
    }

    public Server getServer() {
        return server;
    }

    public String getUsername() {
        return username;
    }
}
