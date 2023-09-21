package main;

import control.PasswordManagerControl;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Password;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        new PasswordManagerControl(primaryStage);
        Password pw = new Password(10, true, true, true, true);
        String s = pw.generatePassword();
    }
}