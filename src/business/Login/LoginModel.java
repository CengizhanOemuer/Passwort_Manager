package business.Login;

import gui.PasswordManager.PasswordManagerControl;
import gui.SignUp.SignUpControl;
import javafx.stage.Stage;
import util.DBUtil;

import java.sql.SQLException;

public class LoginModel {

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
    public void login(Stage primaryStage) {
        new PasswordManagerControl(primaryStage);
    }

    public void tryLogin(String username, String password) {
        // Selecting password_salt for username from users-table:
        String password_salt;

        String encrypted_password = "";

        // Check if username and encrypted_password match with data-bank:
        System.out.println("Login success: " + db.checkUsernameAndPasswordInUsersTable(username, encrypted_password));

    }

    public void openPasswordManagerWindow(Stage primaryStage) {
        new PasswordManagerControl(primaryStage);
    }

    public void openSignUpWindow(Stage primaryStage) {
        new SignUpControl(primaryStage);
    }

}
