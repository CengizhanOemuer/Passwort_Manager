package gui.SignUp;

import business.SignUp.SignUpModel;
import javafx.stage.Stage;

public class SignUpControl {
    // Attributes:
    private SignUpModel signUpModel;
    private SignUpView signUpView;
    // Constructor:
    public SignUpControl(Stage primaryStage) {
        this.signUpModel = new SignUpModel();
        this.signUpView = new SignUpView(this, primaryStage, signUpModel);
    }

    public void trySignUp(String username, String password, String repeatedPassword) {
        if(password.equals(repeatedPassword)) {

        } else {
            
        }
    }
}
