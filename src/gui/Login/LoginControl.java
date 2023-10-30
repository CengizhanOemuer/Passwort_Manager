package gui.Login;

import javafx.stage.Stage;
import business.Login.LoginModel;
import util.DBUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public class LoginControl {

    // MVC-Pattern Attributes:
    private LoginModel loginModel;
    private LoginView loginView;

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
    public LoginControl(Stage primaryStage) {
        this.loginModel = new LoginModel();
        this.loginView = new LoginView(this, primaryStage, loginModel);
    }

    // Methods:
    // Login Method:
    public void tryLogin(String username, String password, Stage primaryStage) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        // Check for correct input:
        if(username.isEmpty() | password.isEmpty()) {
            // Show error message if one text-field is empty!
            loginView.showErrorWindow("Input", "You have to fill out all text-fields!");
        } else if(!(db.checkForUsernameInUsersTable(username))) {
            // Show error message if username does not exist:
            loginView.showErrorWindow("Username", "Username not found in data-bank!");
        } else if(!(loginModel.tryLogin(username, password, primaryStage))) {
            // Show error message if login fails:
            loginView.showErrorWindow("Password", "Password wrong!");
        } else {
            // Show information window if login is successful!
            loginView.showInformationWindow("Login successful!");
        }
    }

    public void openSignUpWindow(Stage primaryStage) {
        this.loginModel.openSignUpWindow(primaryStage);
    }
}
