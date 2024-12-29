/*
 */
package game;

import game.server.Server;
import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author milton
 */
public class ClientMain {
    public static void main(String args[]){
        try {
            Server service = (Server) Naming.lookup("rmi://localhost/Server");
            Scanner scan = new Scanner(System.in);
            do{
                System.out.println("Ingresa una opcion");
                System.out.println("1 Mostrar nombres de usuarios");
                System.out.println("0 Salir");
                int option = scan.nextInt();
                switch(option){
                    case 0: 
                        System.out.print("Bye!");
                        System.exit(0);
                    case 1: showUsers(service);
                    break;
                    default:
                        System.out.println("Error no ingresaste una opcion valida");
                }
            } while(true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void showUsers(Server service) throws Exception{
        List<String> names = null; //service.getUserNames();
        System.out.println("Usuarios dentro del servidor");
        for(String x: names)
            System.out.println(x);
    }
}
