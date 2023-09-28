package business.Login;

import gui.PasswordManager.PasswordManagerControl;
import javafx.stage.Stage;

public class loginModel {

    // MVC-Pattern Constructor:
    public loginModel() {

    }

    // Methods:
    public void login(Stage primaryStage) {
        new PasswordManagerControl(primaryStage);
    }


}
