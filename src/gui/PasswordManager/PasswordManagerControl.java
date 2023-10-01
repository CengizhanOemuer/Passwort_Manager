package gui.PasswordManager;

import business.PasswordManager.PasswordManagerModel;
import javafx.stage.Stage;

public class PasswordManagerControl {
    // MVC-Pattern Attributes:
    private PasswordManagerModel passwordManagerModel;
    private PasswordManagerView passwordManagerView;

    // MVC-Pattern Constructor:
    public PasswordManagerControl(Stage primaryStage) {
        this.passwordManagerModel = new PasswordManagerModel();
        this.passwordManagerView = new PasswordManagerView(this, primaryStage, passwordManagerModel);
    }

    // Methods:
    public String generatePassword(int length, boolean includeUpper, boolean includeLower, boolean includeNumbers, boolean includeSpecialCharacters) {
        return passwordManagerModel.generateNewPassword(length, includeUpper, includeLower, includeNumbers, includeSpecialCharacters);
    }
}
