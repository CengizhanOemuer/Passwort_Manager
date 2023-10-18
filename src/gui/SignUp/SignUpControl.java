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
}
