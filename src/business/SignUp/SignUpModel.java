package business.SignUp;

import gui.Login.LoginControl;
import javafx.stage.Stage;
import util.AESUtil;
import util.DBUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.Arrays;

public class SignUpModel {
    // Attributes:

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
        String salt = AESUtil.generateSalt();

        // Encrypt password using the generated salt:
        String encryptedPassword = AESUtil.encryptPassword(password, password, salt);
        // Save user to db:
        db.insertUserIntoUsersTable(username, salt.getBytes(),encryptedPassword);
        // Close database-connection:
        try {
            db.dbDisconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Open new login window:
        new LoginControl(primaryStage);
    }
}
