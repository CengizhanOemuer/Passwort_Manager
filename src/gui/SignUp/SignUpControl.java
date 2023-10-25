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
        // Check for correct input of the passwords:
        if(password.equals(repeatedPassword)) {
            // Check for already existing usernames:    --> usernames must be unique!
            if(db.checkForUsernameInUsersTable(username)) {
                // If username already exists show error message:
                signUpView.showErrorWindow("Sign Up", "Username already exists!");
            } else {
                // On success call the trySignUp Method from the model:
                signUpModel.trySignUp(username, password, primaryStage);
            }
        } else {
            // If passwords do not match show error message:
            signUpView.showErrorWindow("Sign-Up", "Passwords don't match up!");
        }
    }
}
