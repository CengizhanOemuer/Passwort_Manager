package main;

import gui.Login.LoginControl;
import javafx.application.Application;
import javafx.stage.Stage;
import util.AESUtil;
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
        new LoginControl(primaryStage);

        // Testing:
        passwordManagerDatabase.createTableUsers();
        passwordManagerDatabase.createTablePasswords();
        // passwordManagerDatabase.selectAllPasswordsForOneUser(1);
        // passwordManagerDatabase.checkForUsernameInUsersTable("Cengiz");
        // passwordManagerDatabase.checkForUsernameInUsersTable("Emre");

        AESUtil aes = new AESUtil();
        aes.test();


    }
}