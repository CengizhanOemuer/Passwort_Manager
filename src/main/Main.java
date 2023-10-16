package main;

import gui.Login.loginControl;
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
        new loginControl(primaryStage);

        // Testing:
       passwordManagerDatabase.createTableUsers();
       passwordManagerDatabase.createTablePasswords();
       AESUtil aes = new AESUtil();
       aes.givenPassword_whenEncrypt_thenSuccess();
    }
}