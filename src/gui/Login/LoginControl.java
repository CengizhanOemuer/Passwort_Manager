package gui.Login;

import javafx.stage.Stage;
import business.Login.LoginModel;

public class LoginControl {

    // MVC-Pattern Attributes:
    private LoginModel loginModel;
    private LoginView loginView;

    // MVC-Pattern Constructor:
    public LoginControl(Stage primaryStage) {
        this.loginModel = new LoginModel();
        this.loginView = new LoginView(this, primaryStage, loginModel);
    }

    // Methods:
    public void login(Stage primaryStage) {
        this.loginModel.login(primaryStage);
    }
    public void openSignUpWindow(Stage primaryStage) {
        this.loginModel.openSignUpWindow(primaryStage);
    }
}
