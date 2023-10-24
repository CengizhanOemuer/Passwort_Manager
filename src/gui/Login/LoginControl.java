package gui.Login;

import javafx.stage.Stage;
import business.Login.LoginModel;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

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

    public void tryLogin(String username, String password, Stage primaryStage) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        this.loginModel.tryLogin(username, password, primaryStage);
    }

    public void openSignUpWindow(Stage primaryStage) {
        this.loginModel.openSignUpWindow(primaryStage);
    }
}
