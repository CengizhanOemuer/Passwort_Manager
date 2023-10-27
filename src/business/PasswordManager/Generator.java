package business.PasswordManager;

public class Generator {
    // Attributes:
    private Alphabet alphabet;
    // Constructor:
    public Generator(boolean IncludeUppercase, boolean IncludeLowercase, boolean IncludeNumbers, boolean IncludeSpecialCharacters) {
        alphabet = new Alphabet(IncludeUppercase, IncludeLowercase, IncludeNumbers, IncludeSpecialCharacters);
    }
    // Methods:
    public Password GeneratePassword(int length) {
        final StringBuilder password = new StringBuilder();
        final int alphabetLength = alphabet.getAlphabet().length();

        int max = alphabetLength - 1;
        int min = 0;
        int range = max - min + 1;

        for(int i=0; i<length; i++) {
            int index = (int) (Math.random() * range) + min;
            password.append(alphabet.getAlphabet().charAt(index));
        }

        return new Password(password.toString());
    }
}
