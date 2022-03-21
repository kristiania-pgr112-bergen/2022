package LectureCode.Session17.src;
import LectureCode.Session17.src.equipment.Locker;

import java.sql.*;
public class JDBCOps {
    public JDBCOps(){
/*        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }*/
        try {
            //Registering the Driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean insertLocker(Locker locker) {
        /**
         * try-with-resources from Java7
         */
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                        "=true&useSSL=false", "user1", "pass")) {
            Statement stmt = con.createStatement();
            String insertSql = "INSERT INTO lockers(location)"
                    + " VALUES('" +
                    locker.getLocation() +
                    "')";
            stmt.executeUpdate(insertSql);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertLockerV2(Locker locker) {
        Connection con = null;
        try {
            con = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                            "=true&useSSL=false", "user1", "pass");
            Statement stmt = con.createStatement();
            String insertSql = "INSERT INTO lockers(location)"
                    + " VALUES('" +
                    locker.getLocation() +
                    "')";
            stmt.executeUpdate(insertSql);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        } finally {
            try{
                if(con != null)
                con.close();
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
        return true;
    }

    public boolean createTable() {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                        "=true&useSSL=false", "user1", "pass")) {
            Statement stmt = con.createStatement();
            String createTable = "CREATE TABLE IF NOT EXISTS equipmentBall( "
                    + "id INT NOT NULL AUTO_INCREMENT, "
                    + "needsAir BOOLEAN, "
                    + "location INT NULL, "
                    + "primary key (id)) ";
            boolean result = stmt.execute(createTable);
            /**
             * note that when creating an empty table always returns false
             */
            return result;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
    }
    public int insertEquipmentBalls(){
        int result = 0;
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                        "=true&useSSL=false", "user1", "pass")) {
            Statement stmt = con.createStatement();
            String insertData = "INSERT INTO equipmentBall( "
                    + "id, needsAir, location) VALUES "
                    + "('1', true, '101'), "
                    + "('2', false, '102') ";
            result = stmt.executeUpdate(insertData);
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }
    public void queryEquipmentBalls() {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                        "=true&useSSL=false", "user1", "pass")) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from equipmentBall");
            while (rs.next()) {
                System.out.println("id: "+rs.getInt("id")+", ");
                System.out.println("needsAir: "+rs.getBoolean("needsAir")+", ");
                System.out.println("location: "+rs.getInt("location")+", ");
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
