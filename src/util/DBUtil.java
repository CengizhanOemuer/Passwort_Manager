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

    // Create statements:
    public void createTableUsers() {
        String createTableSQL =
            "create table if not exists users( \n"
            + "id integer primary key autoincrement, \n"
            + "username varchar(255) not null, \n"
            + "password_salt varchar(255) not null, \n"
            + "encrypted_password varchar(255) not null \n"
            + ");";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table 'users' created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error creating table 'users': " + e.getMessage());
        }
    }

    public void createTablePasswords() {
        String createTableSQL =
            "create table if not exists passwords( \n"
            + "id integer primary key autoincrement, \n"
            + "user_id int, \n"
            + "website_name varchar(255) not null, \n"
            + "username varchar(255) not null, \n"
            + "encrypted_password varchar(1024) not null, \n"
            + "foreign key (user_id) references users(id) \n"
            + ");";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
            System.out.println("Table 'passwords' created successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error creating table 'users': " + e.getMessage());
        }
    }

    // Insert statements:
    public void insertUserIntoUser(String username, String encryptedPassword) {
        String insertSQL = "insert into users (username, encrypted_password) values (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, encryptedPassword);
            preparedStatement.executeUpdate();
            System.out.println("users record inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error inserting users record: " + e.getMessage());
        }
    }

    // Select statements:
    public void selectUserFromUsers() {
        String selectSQL = "SELECT * FROM users";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectSQL)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String encryptedPassword = resultSet.getString("encrypted_password");

                System.out.println("ID: " + id);
                System.out.println("Username: " + username);
                System.out.println("Encrypted Password: " + encryptedPassword);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error selecting users: " + e.getMessage());
        }
    }


}
