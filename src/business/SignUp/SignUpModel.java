package business.SignUp;

import gui.Login.LoginControl;
import javafx.stage.Stage;
import util.AESUtil;
import util.DBUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public class SignUpModel {
    // Attributes:

    // AES:
    private AESUtil aes = new AESUtil();
    // Database:
    private DBUtil db;

    {
        try {
            db = new DBUtil("PasswordManager.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Constructor:
    public SignUpModel() {

    }

    // trySignUp-Method:
    public void trySignUp(String username, String password, Stage primaryStage) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        // Generate random-salt for user:
        String salt = aes.generateSalt();
        // Encrypt password using the generated salt:
        String encryptedPassword = aes.encryptPassword(password, password, salt);
        // Save user to db:
        db.insertUserIntoUsersTable(username, salt.getBytes(),encryptedPassword);
        // Open new login window:
        new LoginControl(primaryStage);
    }
}
