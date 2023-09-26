package util;

import java.sql.*;

public class DBUtil {

    // Defining the JDBC_DRIVER:
    private final String JDBC_DRIVER = "jdbc:sqlite:";
    private Connection connection;

    // Constructor:
    public DBUtil(String dbName) throws SQLException {
        dbConnect(dbName);
    }

    // Connect to db:
    public void dbConnect(String dbName) throws SQLException {
        String url = JDBC_DRIVER + dbName;
        try {
            connection = DriverManager.getConnection(url);
            System.out.println("Connection established!");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            e.printStackTrace();
            throw e;
        }
    }

    // Close connection:
    public void dbDisconnect() throws SQLException {
        try {
            if(connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed!");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    // Create table:
    public void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS passwords (\n"
                + "    id INTEGER PRIMARY KEY AUTOINCREMENT,\n"
                + "    website TEXT NOT NULL,\n"
                + "    username TEXT NOT NULL,\n"
                + "    encrypted_password TEXT NOT NULL\n"
                + ");";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table 'passwords' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error creating table 'passwords': " + e.getMessage());
        }
    }

    // Insert:
    public void insertPassword(String website, String username, String encryptedPassword) {
        String insertSQL = "INSERT INTO passwords (website, username, encrypted_password) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, website);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, encryptedPassword);
            preparedStatement.executeUpdate();
            System.out.println("Password record inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error inserting password record: " + e.getMessage());
        }
    }

    // Select:
    public void selectPasswords() {
        String selectSQL = "SELECT * FROM passwords";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String website = resultSet.getString("website");
                String username = resultSet.getString("username");
                String encryptedPassword = resultSet.getString("encrypted_password");

                System.out.println("ID: " + id);
                System.out.println("Website: " + website);
                System.out.println("Username: " + username);
                System.out.println("Encrypted Password: " + encryptedPassword);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error selecting passwords: " + e.getMessage());
        }
    }


}
