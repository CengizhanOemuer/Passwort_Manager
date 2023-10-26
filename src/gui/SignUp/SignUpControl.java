package gui.SignUp;

import business.SignUp.SignUpModel;
import javafx.stage.Stage;
import util.DBUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

public class SignUpControl {
    // Attributes:
    private SignUpModel signUpModel;
    private SignUpView signUpView;
    // Database:
    private final DBUtil db;

    {
        try {
            db = new DBUtil("PasswordManager.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Constructor:
    public SignUpControl(Stage primaryStage) {
        this.signUpModel = new SignUpModel();
        this.signUpView = new SignUpView(this, primaryStage, signUpModel);
    }

    // Sign Up Method:
    public void trySignUp(String username, String password, String repeatedPassword, Stage primaryStage) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        /* Checking for correct input */
        if(username.isEmpty() | password.isEmpty() | repeatedPassword.isEmpty()) {
            // Show error message if one text-field is empty!
            signUpView.showErrorWindow("Input", "You have to fill out all text-fields!");
        } else if(!(password.equals(repeatedPassword))) {
            // Show error message if passwords do not match up!
            signUpView.showErrorWindow("Password", "Your passwords do not match!");
        } else if(db.checkForUsernameInUsersTable(username)) {
            // Show error message if username does exist!
            signUpView.showErrorWindow("Username", "Username already exists!");
        } else {
            // Try to sign up with given input:
            signUpModel.trySignUp(username, password, primaryStage);
        }
    }

    // BackToLogin-Method:
    public void backToLogin(Stage primaryStage) {
        signUpModel.backToLogin(primaryStage);
    }
}
