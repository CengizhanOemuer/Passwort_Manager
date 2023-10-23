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
            if (connection != null && !connection.isClosed()) {
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
    public void insertUserIntoUsersTable(String username, byte[] password_salt, String encryptedPassword) {
        String insertSQL = "insert into users (username, password_salt,encrypted_password) values (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setBytes(2, password_salt);
            preparedStatement.setString(3, encryptedPassword);
            preparedStatement.executeUpdate();
            System.out.println("users record inserted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error inserting users record: " + e.getMessage());
        }
    }

    public void insertPasswordIntoPasswordTable(int user_id, String website_name, String username, String encrypted_password) {
        String insertSQL = "INSERT INTO passwords (user_id, website_name, username, encrypted_password) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setInt(1, user_id);
            preparedStatement.setString(2, website_name);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, encrypted_password);
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error inserting passwords record: " + e.getMessage());
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

    // Select password_salt from users-table for a given user:
    public String selectPasswordSalt(String username) {
        String selectSQL = "SELECT password_salt FROM users WHERE username = (?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()) {
                    if(resultSet.getString("password_salt") != null) return resultSet.getString("password_salt");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error selecting password_salt from users-table: " + e.getMessage());
        }
        return null;
    }

    // Check for correct input of username and password:
    public Boolean checkUsernameAndPasswordInUsersTable(String username, String encrypted_password) {
        String selectSQL = "SELECT username, encrypted_password FROM users where username = (?) and encrypted_password = (?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, encrypted_password);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    if(resultSet.getString("username") != null) {
                        if(resultSet.getString("encrypted_password") != null) return true;
                    } else return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error selecting username and encrypted_password from users-table: " + e.getMessage());
        }
        System.out.println("False");
        return false;
    }

    public Boolean checkForUsernameInUsersTable(String username) {
        String selectSQL = "SELECT username FROM users where username = (?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    if(resultSet.getString("username") != null) {
                        System.out.println("True");
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error selecting username from users-table: " + e.getMessage());
        }
        System.out.println("False");
        return false;
    }

    public void selectAllPasswordsForOneUser(int user_id) {
        String selectSQL = "SELECT * FROM passwords INNER JOIN users on passwords.user_id = users.id where users.id = (?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setInt(1, user_id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                System.out.println("Test1");
                while (resultSet.next()) {
                    System.out.println("Test2");
                    // Passwords table:
                    int idP = resultSet.getInt("id");
                    int user_idP = resultSet.getInt("user_id");
                    String website_nameP = resultSet.getString("website_name");
                    String usernameP = resultSet.getString("username");
                    String encryptedPasswordP = resultSet.getString("encrypted_password");

                    // Users table:
                    int idU = resultSet.getInt("id");
                    String usernameU = resultSet.getString("username");
                    String password_salt = resultSet.getString("password_salt");
                    String encryptedPasswordU = resultSet.getString("encrypted_password");

                    //
                    System.out.println("id: " + idP);
                    System.out.println("user_id: " + user_idP);
                    System.out.println("Website_name: " + website_nameP);
                    System.out.println("Username: " + usernameP);
                    System.out.println("encrypted_password: " + encryptedPasswordP);
                    System.out.println("id: " + idU);
                    System.out.println("UsernameU: " + usernameU);
                    System.out.println("password_salt: " + password_salt);
                    System.out.println("encrypted_password: " + encryptedPasswordU);
                    System.out.println();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error selecting from passwords: " + e.getMessage());
        }
    }


}