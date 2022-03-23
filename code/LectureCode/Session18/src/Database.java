package LectureCode.Session18.src;

import java.sql.*;

public class Database {
    private static final String host = "localhost";
    private static final String port = "3306";
    private static final String name = "PGR112";
    private static final String user = "PGR112";
    private static final String pass = "PGR112";
    
    private static boolean initialized = false;

    public static void loadDriver() {
        if (Database.initialized) {
            return;
        }

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            Database.initialized = true;
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        if (!Database.initialized) Database.loadDriver();

        Connection output = null;

        try {
            output = DriverManager.getConnection(
                    "jdbc:mysql://%s:%s/%s?allowPublicKeyRetrieval=true&useSSL=false".formatted(
                        Database.host, Database.port, Database.name
                    ), Database.user, Database.pass);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }

        return output;
    }
}
