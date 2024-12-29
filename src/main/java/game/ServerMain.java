package game;

import game.server.ServerImpl;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerMain {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            ServerImpl server = new ServerImpl();
            Naming.rebind("rmi://localhost/Server", server);
            System.out.println("Servidor listo...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
