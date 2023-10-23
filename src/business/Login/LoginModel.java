package business.Login;

import gui.PasswordManager.PasswordManagerControl;
import gui.SignUp.SignUpControl;
import javafx.stage.Stage;

public class LoginModel {

    // MVC-Pattern Constructor:
    public LoginModel() {

    }

    // Methods:
    public void login(Stage primaryStage) {
        new PasswordManagerControl(primaryStage);
    }

    public void openSignUpWindow(Stage primaryStage) {
        new SignUpControl(primaryStage);
    }

}
