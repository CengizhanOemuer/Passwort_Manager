package business.PasswordManager;

import gui.Login.LoginControl;
import javafx.stage.Stage;

public class PasswordManagerModel {

    // MVC-Pattern Constructor:
    public PasswordManagerModel() {

    }

    // Methods:
    public static String generatePassword(int length, boolean includeUpper, boolean includeLower, boolean includeNumbers, boolean includeSpecialCharacters) {
       Generator gen = new Generator(includeUpper, includeLower, includeNumbers, includeSpecialCharacters);
       Password password = gen.GeneratePassword(length);
       return password.getValue();
    }

    public void savePasswordIntoDatabank(String website, String username, String password) {

    }

    public static void logOut(Stage primaryStage) {
        new LoginControl(primaryStage);
    }
}
