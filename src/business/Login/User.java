package business.Login;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {
    // Attributes:
    private String username;
    private String encryptedPassword;

    // Constructor:
    public User(String username, String password) throws NoSuchAlgorithmException {
        this.username = username;
        this.encryptedPassword = encryptPassword(password);
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

    public void setEncryptedPassword(String password) throws NoSuchAlgorithmException {
        this.encryptedPassword = encryptPassword(password);
    }

    // Methods:
    private String encryptPassword(String password) throws NoSuchAlgorithmException {
        // Initializing an instance of MessageDigest with sha256:
        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        // Converting the input-string to bytes and updating the MessageDigest:
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

        // Converting the byte[] in a hex-string using a StringBuilder:
        StringBuilder hexString = new StringBuilder();
        for(byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        System.out.println("SHA-256 Hash: " + hexString.toString());
        return hexString.toString();
    }

}
