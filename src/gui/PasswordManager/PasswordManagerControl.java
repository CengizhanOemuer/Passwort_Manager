package gui.PasswordManager;

import business.PasswordManager.PasswordManagerModel;
import javafx.stage.Stage;

public class PasswordManagerControl {
    // MVC-Pattern Attributes:
    private static PasswordManagerModel passwordManagerModel;
    private PasswordManagerView passwordManagerView;

    // MVC-Pattern Constructor:
    public PasswordManagerControl(Stage primaryStage) {
        this.passwordManagerModel = new PasswordManagerModel();
        this.passwordManagerView = new PasswordManagerView(this, primaryStage, passwordManagerModel);
    }

    // Methods:
    public static String generatePassword(int length, boolean includeUpper, boolean includeLower, boolean includeNumbers, boolean includeSpecialCharacters) {
        return passwordManagerModel.generatePassword(length, includeUpper, includeLower, includeNumbers, includeSpecialCharacters);
    }

    public void savePasswordIntoDatabank(String website, String username, String password) {
        passwordManagerModel.savePasswordIntoDatabank(website, username, password);
    }
    public static void logOut(Stage primaryStage) {
        PasswordManagerModel.logOut(primaryStage);
    }
}
