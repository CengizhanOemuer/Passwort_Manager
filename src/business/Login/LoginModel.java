package business.Login;

import gui.PasswordManager.PasswordManagerControl;
import gui.SignUp.SignUpControl;
import javafx.stage.Stage;
import util.AESUtil;
import util.DBUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.Arrays;

public class LoginModel {
    // AES:
    private final AESUtil aes = new AESUtil();
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
    public LoginModel() {

    }

    // Methods:
    public Boolean tryLogin(String username, String password, Stage primaryStage) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        // Selecting password_salt for username from users-table:
        String password_salt = db.selectPasswordSaltFromUsersTable(username);

        // Encrypting password with user-specific password_salt:
        String encrypted_password = AESUtil.encryptPassword(password, password, password_salt);

        // Check if username and encrypted_password match with data-bank:
        System.out.println("Login success: " + db.checkUsernameAndPasswordInUsersTable(username, encrypted_password));

        // Open PasswordManagerWindow if username and encrypted_password match:
        if(db.checkUsernameAndPasswordInUsersTable(username, encrypted_password)) {
            openPasswordManagerWindow(primaryStage, username, encrypted_password);
            return true;
        }
        return false;
    }

    public void openPasswordManagerWindow(Stage primaryStage, String username, String encrypted_password) {
        new PasswordManagerControl(primaryStage, username, encrypted_password);
    }

    public void openSignUpWindow(Stage primaryStage) {
        new SignUpControl(primaryStage);
    }

}
