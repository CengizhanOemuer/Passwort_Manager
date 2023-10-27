package business.PasswordManager;

public class Alphabet {
    // Attributes:
    private final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private final String NUMBERS = "0123456789";
    private final String SPECIAL_CHARACTERS = "!§$%&/()=?.:,;+*#<>";
    private final StringBuilder character_pool;
    // Constructor:
    public Alphabet(boolean includeUppercase, boolean includeLowercase, boolean includeNumbers, boolean includeSpecialCharacters) {
        character_pool = new StringBuilder();
        if(includeUppercase) character_pool.append(UPPERCASE_LETTERS);
        if(includeLowercase) character_pool.append(LOWERCASE_LETTERS);
        if(includeNumbers) character_pool.append(NUMBERS);
        if(includeSpecialCharacters) character_pool.append(SPECIAL_CHARACTERS);
    }
    // Getter:
    public String getAlphabet() {
        return character_pool.toString();
    }
}
