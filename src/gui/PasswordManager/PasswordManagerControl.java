package gui.PasswordManager;

import business.PasswordManager.PasswordManagerModel;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class PasswordManagerControl {
    // MVC-Pattern Attributes:
    private static PasswordManagerModel passwordManagerModel;
    private static PasswordManagerView passwordManagerView;

    // MVC-Pattern Constructor:
    public PasswordManagerControl(Stage primaryStage, String username, String encrypted_password) {
        this.passwordManagerModel = new PasswordManagerModel(username, encrypted_password);
        this.passwordManagerView = new PasswordManagerView(this, primaryStage, passwordManagerModel);
    }

    // Methods:
    public static String generatePassword(int length, boolean includeUpper, boolean includeLower, boolean includeNumbers, boolean includeSpecialCharacters) {
        return passwordManagerModel.generatePassword(length, includeUpper, includeLower, includeNumbers, includeSpecialCharacters);
    }

    public static void savePasswordIntoDatabank(String website, String username, String password) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        if(website.isEmpty() | username.isEmpty() | password.isEmpty()) {
            passwordManagerView.showErrorWindow("Input", "Password could not be saved.\nPlease fill out all text-fields!");
        }
        passwordManagerModel.savePasswordIntoDatabank(website, username, password);
        passwordManagerView.showInformationWindow("Password saved successfully!");
    }
    public static void logOut(Stage primaryStage) {
        PasswordManagerModel.logOut(primaryStage);
    }
}
