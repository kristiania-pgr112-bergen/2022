package LectureCode.Session20.src;

import LectureCode.Session20.src.equipment.Ball;
import LectureCode.Session20.src.equipment.Locker;

import java.sql.*;
import java.util.ArrayList;

public class JDBCOps {
    public JDBCOps(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }


    public void createTable() {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                        "=true&useSSL=false", "user1", "pass")) {
            Statement stmt = con.createStatement();
            String createEquipmentBallTable = "CREATE TABLE IF NOT EXISTS equipmentBall( "
                    + "id INT NOT NULL AUTO_INCREMENT, "
                    + "type VARCHAR(255), "
                    + "needsAir BOOLEAN, "
                    + "location INT, "
                    + "primary key (id)) ";
            stmt.execute(createEquipmentBallTable);
            String createLockerTable = "CREATE TABLE IF NOT EXISTS lockers( "
                    + "id INT NOT NULL AUTO_INCREMENT, "
                    + "location VARCHAR(255), "
                    + "address VARCHAR(255), "
                    + "primary key (id)) ";
            stmt.execute(createLockerTable);
            /**
             * note that when creating an empty table always returns false
             */
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
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

    public boolean updateLocker(Locker locker) {
        /**
         * try-with-resources from Java7
         */
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?" +
                        "allowPublicKeyRetrieval=true&useSSL=false" +
                        "&allowMultiQueries=true", "user1", "pass")) {
            Statement stmt = con.createStatement();
            String selectLocker = "UPDATE lockers SET address='" + locker.getAddress() +
                    "' WHERE location='" +
                    locker.getLocation() +
                    "'";
            System.out.println(selectLocker);
            int resultSet = stmt.executeUpdate(selectLocker);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
        return true;
    }
    public int insertBall(Ball ball){
        int result = 0;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                "=true&useSSL=false", "user1", "pass")) {
            Statement stmt = con.createStatement();
            int needsAir = (ball.needsAir()) ? 1 : 0;

            String insertSql = "INSERT INTO equipmentBall(type, needsAir, location)"
                    + " VALUES('" +
                    ball.getType() + "', '" +
                    needsAir + "', '" +
                    ball.getLocation().getId() +
                    "')";
            stmt.executeUpdate(insertSql);
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public Locker getLockerById(int id){
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                "=true&useSSL=false", "user1", "pass")) {

            Statement stmt = con.createStatement();
            String selectLocker = "SELECT * FROM lockers " +
                    "WHERE id=" +
                    id;

            ResultSet resultSet = stmt.executeQuery(selectLocker);
            while(resultSet.next()){
                Locker locker = new Locker();
                locker.setId(resultSet.getInt("id"));
                locker.setLocation(resultSet.getString("location"));
                return locker;
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
        return null;
    }

    public ArrayList<Locker> getAllLockers(){
        ArrayList<Locker> results = new ArrayList<>();

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                "=true&useSSL=false", "user1", "pass")) {

            Statement stmt = con.createStatement();

            String selectSql = "SELECT * FROM lockers";

            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()){
                Locker lock = new Locker();
                lock.setId(resultSet.getInt("id"));
                lock.setLocation(resultSet.getString("location"));
                results.add(lock);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return results;
    }

    public ArrayList<Locker> getLockersByLocation(String location){
        ArrayList<Locker> results = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?" +
                "allowPublicKeyRetrieval=true&useSSL=false",  "user1", "pass")) {
            Statement stmt = con.createStatement();
            String selectSql = "SELECT * FROM lockers WHERE location = '"
                    + location + "'";
            ResultSet resultSet = stmt.executeQuery(selectSql);
            while (resultSet.next()){
                Locker lock = new Locker();
                lock.setId(resultSet.getInt("id"));
                lock.setLocation(resultSet.getString("location"));
                results.add(lock);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return results;
    }

    public ArrayList<Ball> getAllBallsByJoin() {
        ArrayList<Ball> results = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                "=true&useSSL=false", "user1", "pass")) {
            Statement stmt = con.createStatement();
            String joinSql = "SELECT ball.id as id, ball.type as type, ball.needsAir as needsAir, locker.id as locationId, locker.location as location " +
                    "FROM equipmentBall ball " +
                    "INNER JOIN lockers locker " +
                    "ON ball.location=locker.id";

            ResultSet resultSet = stmt.executeQuery(joinSql);
            while(resultSet.next()){
                int ballId = resultSet.getInt("id");
                Ball ball = new Ball(ballId);
                ball.setType(resultSet.getString("type"));
                ball.setNeedsAir(resultSet.getBoolean("needsAir"));
                Locker locker = new Locker();
                locker.setId(resultSet.getInt("locationId"));
                locker.setLocation(resultSet.getString("location"));
                ball.setLocation(locker);
                results.add(ball);
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return results;
    }

}
