package game.server.dto;

import java.io.Serializable;

/**
 *
 * @author pi
 */
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    public UserDTO(String username) {
        this.username = username;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
