package LectureCode.Lecture17.src;

import LectureCode.Lecture17.src.equipments.Equipment;
import LectureCode.Lecture17.src.equipments.Locker;
import org.junit.platform.engine.support.hierarchical.ExclusiveResource;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {
    public static void main(String[] args) {
        registerDriver();
        createDb();
        getConnectionsAndDoQueries();
    }
    public static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }
        /*        try {
            //Registering the Driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public static void createDb() {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/", "user1", "pass")) {
            Statement stmt = con.createStatement();
            String sql = "CREATE DATABASE equipmentBallsDb";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
    }

    public static void getConnectionsAndDoQueries() {
        /**
         * try-with-resources from Java7
         */
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                        "=true&useSSL=false", "user1", "pass")) {
            createTable(con);
            //dropTable(con);
            insertLocker(con);
            updateLocker(con);
            showLockers(con);

            changeLockerAddessForFirstLocker(con);
            showLockers(con);
            Locker mylocker = getLockerById(con,1);
            System.out.println(mylocker);

            Equipment ball = new Equipment();
            ball.setNeedsAir(1);
            ball.setLocation(mylocker);
            insertEquipmentBall(con, ball);

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
    }
    public static void insertEquipmentBall(Connection con, Equipment equipment) throws SQLException {
        Statement stmt = con.createStatement();
        String insertSql = "insert into equipmentBall(needsAir, location)"
                + "values('"
                + equipment.getNeedsAir()
                + "', '"
                +equipment.getLocation().getId()
                +"')";
        stmt.executeUpdate(insertSql);
    }

    public static Locker getLockerById(Connection con, int id) throws SQLException {
        Statement stmt = con.createStatement();
        String getSql = "select * from lockers where id='" + id +"'";
        ResultSet resultSet = stmt.executeQuery(getSql);
        while(resultSet.next()) {
            Locker mylocker = new Locker();
            mylocker.setId(resultSet.getInt("id"));
            mylocker.setLocation(resultSet.getString("location"));
            mylocker.setAddress(resultSet.getString("address"));
            return mylocker;
        }
        return null;
    }

    public static void changeLockerAddessForFirstLocker(Connection con) throws SQLException
    {
        Statement stmt = con.createStatement();
        String changeSql = "update lockers"
                + " set address = 'special address'"
                + " where id = 1";
        int result = stmt.executeUpdate(changeSql);
        System.out.println(result);
    }
    public static void createTable(Connection con) throws SQLException {
            Statement stmt = con.createStatement();
            String createTable = "CREATE TABLE IF NOT EXISTS equipmentBall( "
                    + "id INT NOT NULL AUTO_INCREMENT, "
                    + "needsAir BOOLEAN, "
                    + "location INT NULL, "
                    + "primary key (id)) ";
            boolean result = stmt.execute(createTable);
            createTable = "CREATE TABLE IF NOT EXISTS lockers( "
                    + "id INT NOT NULL AUTO_INCREMENT, "
                    + "location VARCHAR(45), "
                    + "address VARCHAR(45), "
                    + "primary key (id)) ";
            result = stmt.execute(createTable);

    }
    public static void dropTable(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        String dropTable = "DROP TABLE IF EXISTS equipmentBall, lockers";
        boolean result = stmt.execute(dropTable);
    }
    public static void insertLocker(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        for(int i = 0; i <10; i++) {
            Locker locker = new Locker();
            locker.setLocation("Locker " + i);
            String insertLockers = "INSERT INTO lockers(location)"
                    + " VALUES('"
                    + locker.getLocation()
                    + "')";
            boolean result = stmt.execute(insertLockers);
        }
    }
    public static void updateLocker(Connection con) throws SQLException {
        Statement stmt = con.createStatement();
        for(int i = 1; i <=10; i++) {
            Locker locker = new Locker();
            locker.setAddress("Address " + i);
            String updateLockers = "update lockers "
                    + "set address = '"
                    + locker.getAddress()
                    + "' where id = "
                    + i;
            boolean result = stmt.execute(updateLockers);
        }
    }
    public static void showLockers(Connection con) throws SQLException {
        ArrayList<Locker> lockers = new ArrayList<>();
        Statement stmt = con.createStatement();
        String showLockers = "select * from lockers";
        ResultSet rs = stmt.executeQuery(showLockers);
        while (rs.next()) {
            Locker locker = new Locker();
            locker.setId(rs.getInt("id"));
            locker.setLocation(rs.getString("location"));
            locker.setAddress(rs.getString("address"));
            lockers.add(locker);
        }
        lockers.forEach(locker ->
        {
            System.out.println("id: "+locker.getId()+", ");
            System.out.println("location: "+locker.getLocation()+", ");
            System.out.println("address: "+locker.getAddress()+", ");
        });
    }

}
