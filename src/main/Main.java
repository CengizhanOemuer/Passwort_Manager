package main;

import control.PasswordManagerControl;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Password;
import model.User;
import util.DBUtil;
import java.sql.SQLException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        DBUtil passwordManagerDatabase = null;
        try {
            // Initialize the database:
            passwordManagerDatabase = new DBUtil("PasswordManager.db");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Initialize the PasswordManager-Application:
        new PasswordManagerControl(primaryStage);

        // Testing:
        Password pw = new Password(10, true, true, true, true);
        String s = pw.generatePassword();
        User user = new User("Cengizhan", "MeinLieblingsPasswort123");
        User user2 = new User("Emre", "EmresPasswort123-");
        passwordManagerDatabase.createTable();
        passwordManagerDatabase.insertUserIntoUser("Cengiz", user.getEncryptedPassword());
        passwordManagerDatabase.insertUserIntoUser("Emre", user2.getEncryptedPassword());
        passwordManagerDatabase.selectUserFromUsers();
    }
}