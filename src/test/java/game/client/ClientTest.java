/*
 */
package game.client;

import org.junit.Test;
import static org.junit.Assert.*;
import static game.client.Client.*;
import game.server.db.Message;
import game.server.dto.MessageDTO;
import game.server.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author milton
 */
public class ClientTest {
    
    @Test
    public void testGetName() throws Exception {
        String expResult = CLIENT_NAME1;
        Client instance = new ClientImpl(expResult);
        String result = instance.getName();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testUpdateList() throws Exception{
        ClientImpl client = new ClientImpl(CLIENT_NAME1);
        List<UserDTO> result = new ArrayList();
        client.whenUpdateUsersDo((users)->{
            result.addAll(users);
        });
        List<UserDTO> expected = new ArrayList();
        expected.add(new UserDTO(CLIENT_NAME2));
        expected.add(new UserDTO(CLIENT_NAME3));
        
        client.updateContectedUsers(expected);
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testReceiveAMessage() throws Exception{
        ClientImpl client = new ClientImpl(CLIENT_NAME1);
        ArrayList<MessageDTO> list = new ArrayList();
        client.whenNewMessageDo(list::add);
        String expected = Message.HI;
        client.receiveMessage(new MessageDTO(expected, CLIENT_NAME2));
        String result = list.get(0).getMessage();
        assertEquals(expected, result);
    }
}
