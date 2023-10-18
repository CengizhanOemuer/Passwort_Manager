package gui.Login;

import javafx.stage.Stage;
import business.Login.loginModel;

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
    public void openSignUpWindow(Stage primaryStage) {
        this.loginModel.openSignUpWindow(primaryStage);
    }
}
