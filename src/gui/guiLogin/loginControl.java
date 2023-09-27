package gui.guiLogin;

import javafx.stage.Stage;
import business.businessLogin.loginModel;

public class loginControl {

    // MVC-Pattern Attributes:
    private loginModel loginModel;
    private loginView loginView;

    // MVC-Pattern Constructor:
    public loginControl(Stage primaryStage) {
        this.loginModel = new loginModel();
        this.loginView = new loginView(this, primaryStage, loginModel);
    }

    // Methods:
    public void login(Stage primaryStage) {
        this.loginModel.login(primaryStage);
    }
}
