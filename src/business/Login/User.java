package business.Login;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    // Attributes:
    private String username;
    private String encryptedPassword;

    // Constructors:
    public User(String username, String password) {
        this.username = username;
        this.encryptedPassword = password;
    }
    public User() {

    }

    // Getters & Setters:
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String password) {
        this.encryptedPassword = password;
    }

}
