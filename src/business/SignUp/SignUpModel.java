package business.SignUp;

import util.DBUtil;

import java.sql.SQLException;

public class SignUpModel {
    // Attributes:

    // Database:
    private DBUtil db;

    {
        try {
            db = new DBUtil("PasswordManager.db");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Constructor:
    public SignUpModel() {

    }

    // trySignUp-Method:
    public void trySignUp(String username, String password, String repeatedPassword) {
        String encryptedPassword = "Placeholder";
        db.insertUserIntoUsersTable(username, encryptedPassword);
    }
}
