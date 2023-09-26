package main;

import control.PasswordManagerControl;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Password;
import util.DBUtil;
import java.sql.SQLException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Initialize the database
        // try {
            // DBUtil passwordManagerDatabase = new DBUtil("PasswordManager.db");
            new PasswordManagerControl(primaryStage);
            Password pw = new Password(10, true, true, true, true);
            String s = pw.generatePassword();
            // passwordManagerDatabase.createTable();
            // passwordManagerDatabase.insertPassword("Testwebsite", "Cengiz", "#123#das#21#dd#");
            // passwordManagerDatabase.selectPasswords();
        // } catch (SQLException e) {
            // e.printStackTrace();
            // Handle database initialization error
        // }
    }
}