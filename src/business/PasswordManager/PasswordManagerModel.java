package business.PasswordManager;

import util.PasswordGenerator;

public class PasswordManagerModel {

    // MVC-Pattern Constructor:
    public PasswordManagerModel() {

    }

    // Methods:
    public String generateNewPassword(int length,boolean includeUpper, boolean includeLower, boolean includeNumbers, boolean includeSpecialCharacters) {
        PasswordGenerator pG = new PasswordGenerator(length, includeUpper, includeLower, includeNumbers, includeSpecialCharacters);
        return pG.generatePassword();
    }

    public void savePasswordIntoDatabank(String website, String username, String password) {

    }
}
