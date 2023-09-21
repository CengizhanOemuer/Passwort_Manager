package model;

public class Password {
    // final Attributes:
    private final String lower = "abcdefghijklmnopqrstuvwxyz";
    private final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String numbers = "0123456789";
    private final String specialsCharacters = "!§$%&/()=?.:,;+*#<>";

    // Attributes:
    private int length;
    private boolean includeLower;
    private boolean includeUpper;
    private boolean includeNumbers;
    private boolean includeSpecialCharacters;

    // Constructor:
    public Password(int length, boolean includeLower, boolean includeUpper, boolean includeNumbers, boolean includeSpecialCharacters) {
        this.length = length;
        this.includeLower = includeLower;
        this.includeUpper = includeUpper;
        this.includeNumbers = includeNumbers;
        this.includeSpecialCharacters = includeSpecialCharacters;
    }

    // Getter & Setter:


    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isIncludeLower() {
        return includeLower;
    }

    public void setIncludeLower(boolean includeLower) {
        this.includeLower = includeLower;
    }

    public boolean isIncludeUpper() {
        return includeUpper;
    }

    public void setIncludeUpper(boolean includeUpper) {
        this.includeUpper = includeUpper;
    }

    public boolean isIncludeNumbers() {
        return includeNumbers;
    }

    public void setIncludeNumbers(boolean includeNumbers) {
        this.includeNumbers = includeNumbers;
    }

    public boolean isIncludeSpecialCharacters() {
        return includeSpecialCharacters;
    }

    public void setIncludeSpecialCharacters(boolean includeSpecialCharacters) {
        this.includeSpecialCharacters = includeSpecialCharacters;
    }

    // Methods:
    private int getRandomIndex(String chars) {
        int min = 0; int max = chars.length();
        return (int)(Math.random() * ((max - min) + 1)) + min;
    }

    private String combineAllCharacters() {
        String allCharacters = "";
        if(includeLower) {
            allCharacters += this.lower;
        }
        if(includeUpper) {
            allCharacters += this.upper;
        }
        if(includeNumbers) {
            allCharacters += this.numbers;
        }
        if(includeSpecialCharacters) {
            allCharacters += this.specialsCharacters;
        }
        return allCharacters;
    }

    public String generatePassword() {
        StringBuilder result = new StringBuilder(this.length);
        String allCharacters = combineAllCharacters();

        for(int i = 0; i < this.length; i++) {
            result.append(allCharacters.charAt(getRandomIndex(allCharacters)));
        }
        System.out.println("Password: " + result);
        return result.toString();
    }
}


