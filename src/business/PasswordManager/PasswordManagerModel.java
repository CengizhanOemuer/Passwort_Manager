package business.PasswordManager;

public class PasswordManagerModel {

    // MVC-Pattern Constructor:
    public PasswordManagerModel() {

    }

    // Methods:
    public String generateNewPassword(int length,boolean includeUpper, boolean includeLower, boolean includeNumbers, boolean includeSpecialCharacters) {
        PasswordGenerator pG = new PasswordGenerator(length, includeUpper, includeLower, includeNumbers, includeSpecialCharacters);
        return pG.generatePassword();
    }
}
