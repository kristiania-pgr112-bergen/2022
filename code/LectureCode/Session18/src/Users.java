package LectureCode.Session18.src;

import java.sql.*;


public class Users {

    public static void printAllUsers() {
        try (Connection db = Database.getConnection()) {
            String query = "SELECT * FROM users;";

            Statement statement = db.createStatement();

            ResultSet result = statement.executeQuery(query);
            ResultSetMetaData meta = result.getMetaData();

            int columnCount = meta.getColumnCount();

            while(result.next()) {
                for (int i = 0; i < columnCount; i ++) {
                    Object valueInColumn = result.getObject(i);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean userExists(String username) {
        try (Connection db = Database.getConnection()) {

            String query = "SELECT id FROM users WHERE username = ?;";

            PreparedStatement statement = db.prepareStatement(query);

            statement.setString(1, username);

            ResultSet result = statement.executeQuery();

            return result.next();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean addUser(String username, String password) {
        try (Connection db = Database.getConnection()) {
            if (Users.userExists(username)) {
                return false;
            }
            else {
                String query = "INSERT INTO users (username, password) VALUES (?, ?);";

                PreparedStatement statement = db.prepareStatement(query);

                statement.setString(1, username);
                statement.setString(2, password);

                statement.execute();

                return true;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean removeUser(String username) {
        try (Connection db = Database.getConnection()) {
            if (Users.userExists(username)) {
                String query = "DELETE FROM users WHERE username = ?;";

                PreparedStatement statement = db.prepareStatement(query);

                statement.setString(1, username);

                statement.execute();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }



    public static void main(String[] args) {
        if (Users.userExists("mada051")) {
            System.out.println("User exists, deleting ...!");

            Users.removeUser("mada051");
        }
        else {
            System.out.println("User does not exists, creating ...");
            Users.addUser("mada051", "detteerikkeetsikkertpassord");
        }
    }
}
