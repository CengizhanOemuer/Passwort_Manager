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
    public void login(Stage primaryStage) {
        this.loginModel.login(primaryStage);
    }

    // Login Method:
    public void tryLogin(String username, String password, Stage primaryStage) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        // Check for correct input:
        if(username.isEmpty() | password.isEmpty()) {
            // If one text-field is empty show error message:
            loginView.showErrorWindow("Login", "You have to fill out both text-fields!");
        } else if (db.checkForUsernameInUsersTable(username)) {
            // Check whether password matches password in db:
            if(loginModel.tryLogin(username, password, primaryStage)) {
                // On success show information window:
                loginView.showInformationWindow("Login was successful!");
            } else {
                // If password does not match, show error window:
                loginView.showErrorWindow("Login", "Password does not match password in data-bank!");
            }
        } else {
            // If username does not exist show error message:
            loginView.showErrorWindow("Login", "No such user!");
        }
    }

    public void openSignUpWindow(Stage primaryStage) {
        this.loginModel.openSignUpWindow(primaryStage);
    }
}
