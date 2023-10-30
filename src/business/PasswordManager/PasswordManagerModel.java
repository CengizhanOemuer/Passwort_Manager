package business.PasswordManager;

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

public class PasswordManagerModel {
    // Attributes:
    private String username, encrypted_password;

    // Database:
    private final DBUtil db;

    {
        try {
            db = new DBUtil("PasswordManager.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // MVC-Pattern Constructor:
    public PasswordManagerModel(String username, String encrypted_password) {
        this.username = username;
        this.encrypted_password = encrypted_password;
    }

    // Methods:
    public static String generatePassword(int length, boolean includeUpper, boolean includeLower, boolean includeNumbers, boolean includeSpecialCharacters) {
       Generator gen = new Generator(includeUpper, includeLower, includeNumbers, includeSpecialCharacters);
       Password password = gen.GeneratePassword(length);
       return password.getValue();
    }

    public void savePasswordIntoDatabank(String website, String username, String password) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        // Selecting user_id from users-table:
        int user_id = db.selectUserIDFromUsersTable(this.username);
        // Selecting password_salt for user:
        String salt = db.selectPasswordSaltFromUsersTable(this.username);
        // Encrypt password using the user-specific-salt:
        String encrypted_password = AESUtil.encryptPassword(password, password, salt);
        // Inserting password with given information:
        db.insertPasswordIntoPasswordTable(user_id, website, username, encrypted_password);
    }

    public static void logOut(Stage primaryStage) {
        new LoginControl(primaryStage);
    }
}
