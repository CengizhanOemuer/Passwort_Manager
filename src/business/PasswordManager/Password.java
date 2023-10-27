package business.PasswordManager;

public class Password {
    // Attributes:
    private String value;
    private int length;
    // Constructor:
    public Password(String value) {
        this.value = value;
        this.length = value.length();
    }
    // Methods:
    public String getValue() {
        return this.value;
    }
    public int getLength() {
        return this.length;
    }
}
