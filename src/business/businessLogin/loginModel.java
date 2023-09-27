package business.businessLogin;

import gui.guiPasswordManager.PasswordManagerControl;
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
