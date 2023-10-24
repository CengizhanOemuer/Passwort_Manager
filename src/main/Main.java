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
        // DB-Init:
        DBUtil db = new DBUtil("PasswordManager.db");
        db.createTableUsers();
        db.createTablePasswords();

        // Initialize the PasswordManager-Application:
        new LoginControl(primaryStage);
    }
}