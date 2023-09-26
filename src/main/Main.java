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
        try {
            // Initialize the database:
            DBUtil passwordManagerDatabase = new DBUtil("PasswordManager.db");
//            passwordManagerDatabase.createTable();
//            passwordManagerDatabase.insertPassword("Testwebsite", "Cengiz", "#123#das#21#dd#");
//            passwordManagerDatabase.selectPasswords();
         } catch (SQLException e) {
             e.printStackTrace();
         }
        // Initialize the PasswordManager-Application:
        new PasswordManagerControl(primaryStage);

        // Testing:
        Password pw = new Password(10, true, true, true, true);
        String s = pw.generatePassword();
        User user = new User("Cengizhan", "MeinLieblingsPasswort123");
    }
}