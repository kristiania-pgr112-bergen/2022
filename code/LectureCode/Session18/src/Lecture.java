package LectureCode.Session18.src;

import java.sql.*;


public class Lecture {
    public static void main(String[] args)
    {
        String query;

        try (Connection db = Database.getConnection()) {

            //# Create table if it does not exist
            query = "CREATE TABLE IF NOT EXISTS users"
            + "("
                    + "id INT NOT NULL AUTO_INCREMENT, "
                    + "username VARCHAR(64), "
                    + "password VARCHAR(256), "
                    + "PRIMARY KEY(id)"
            + ")";

            Statement statement = db.createStatement();

            statement.execute(query);

            //# Create admin user if it does not exist
            query = "SELECT * FROM users WHERE username = 'admin';";

            if (statement.execute(query)) {
                System.out.println("Admin user already exists!");
            }
            else {
                System.out.println("Admin user does not exist, let us create it!");

                query = "INSERT INTO users(username, password) VALUES (?, ?)";

                PreparedStatement newUser = db.prepareStatement(query);

                newUser.setString(1, "admin");
                newUser.setString(2, "admin-password");

                newUser.execute();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
};
