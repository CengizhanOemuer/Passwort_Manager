package model;

public class Password {
    // final Attributes:
    private final String lower = "abcdefghijklmnopqrstuvwxyz";
    private final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String numbers = "0123456789";
    private final String specialsCharacters = "!§$%&/()=?.:,;+*#<>";

    // Attributes:
    private int length;
    private boolean useLower;
    private boolean useUpper;
    private boolean useNumbers;
    private boolean useSpecialCharacters;

    // Constructor:
    public Password(int length, boolean useLower, boolean useUpper, boolean useNumbers, boolean useSpecialCharacters) {
        this.length = length;
        this.useLower = useLower;
        this.useUpper = useUpper;
        this.useNumbers = useNumbers;
        this.useSpecialCharacters = useSpecialCharacters;
    }

    // Getter & Setter:
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isUseLower() {
        return useLower;
    }

    public void setUseLower(boolean useLower) {
        this.useLower = useLower;
    }

    public boolean isUseUpper() {
        return useUpper;
    }

    public void setUseUpper(boolean useUpper) {
        this.useUpper = useUpper;
    }

    public boolean isUseNumbers() {
        return useNumbers;
    }

    public void setUseNumbers(boolean useNumbers) {
        this.useNumbers = useNumbers;
    }

    public boolean isUseSpecialCharacters() {
        return useSpecialCharacters;
    }

    public void setUseSpecialCharacters(boolean useSpecialCharacters) {
        this.useSpecialCharacters = useSpecialCharacters;
    }

    // Methods:
}
