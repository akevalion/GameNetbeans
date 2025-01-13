/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

import game.client.ClientWindow;
import game.server.Server4Test;
/**
 *
 * @author pi
 */
public class DebugMain {
    public static void main(String[] args) throws Exception{
        ClientWindow window = new ClientWindow();
        window.setServer(new Server4Test());
        window.open();
    }
}
