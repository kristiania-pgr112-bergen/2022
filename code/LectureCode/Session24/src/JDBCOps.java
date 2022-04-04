package LectureCode.Session24.src;

import LectureCode.Session24.src.equipment.Ball;
import LectureCode.Session24.src.equipment.Locker;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JDBCOps {
    Connection conn = null;
    HashMap<Integer, Locker> lockers = new HashMap<>();
    HashMap<Integer, Ball> balls = new HashMap<>();

    public JDBCOps(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?" +
                            "allowPublicKeyRetrieval=true&useSSL=false" +
                            "&allowMultiQueries=true", "user1", "pass");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        createTable();

    }

    public void createTable() {
        try {
            Statement stmt = conn.createStatement();
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
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void generateAndInsertLockers(){
        for (int i = 0; i < 10; i++){
            Locker locker = new Locker();
            locker.setLocation("Locker " + i);
            lockers.put(i, locker);
        }
        try ( PreparedStatement insertSql=conn.prepareStatement(
                "INSERT INTO lockers(location) VALUES(?)");)
        {
            conn.setAutoCommit(false);
            for (Map.Entry<Integer, Locker> locker : lockers.entrySet()) {
                insertSql.setString(1,locker.getValue().getLocation());
                insertSql.executeUpdate();
                conn.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    conn.rollback();
                } catch (SQLException excep) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void generateAndInsertBalls(){
        int lockerIndex = 0;
        for (int i = 0; i < 20; i++){
            Ball ball = new Ball();
            ball.setType(Ball.getRandomType());
            ball.setNeedsAir(false);
            ball.setLocation(lockers.get(lockerIndex));
            if(lockerIndex >= 9) lockerIndex = 0;
            else lockerIndex++;
            balls.put(i, ball);
        }

        try ( PreparedStatement insertSql=conn.prepareStatement(
                "INSERT INTO lockers(location) VALUES(?)");)
        {
            conn.setAutoCommit(false);
            for (Map.Entry<Integer, Ball> ball : balls.entrySet()) {
                int needsAir = (ball.getValue().needsAir()) ? 1 : 0;
                PreparedStatement stmt=conn.prepareStatement("INSERT INTO equipmentBall(type, needsAir, location) VALUES(?,?,?)");
                stmt.setString(1,ball.getValue().getType());
                stmt.setInt(2, needsAir);
                stmt.setInt(3, ball.getValue().getLocation().getId());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    System.err.print("Transaction is being rolled back");
                    conn.rollback();
                } catch (SQLException excep) {
                    e.printStackTrace();
                }
            }
        }

    }

    public Locker getLockerById(int id){
        try ( PreparedStatement getLockerSql =
                      conn.prepareStatement("SELECT * FROM lockers where id=?")) {
            getLockerSql.setInt(1,id);
            ResultSet resultSet = getLockerSql.executeQuery();
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
        try (PreparedStatement getLockersSql = conn.prepareStatement("SELECT * FROM lockers")) {
            ResultSet resultSet = getLockersSql.executeQuery();
            while (resultSet.next()){
                Locker lock = new Locker();
                lock.setId(resultSet.getInt("id"));
                lock.setLocation(resultSet.getString("location"));
                lock.setAddress(resultSet.getString("address"));
                results.add(lock);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return results;
    }

    public Optional<ArrayList<Locker>> getLockersByLocationOptional(String location){
        ArrayList<Locker> results = null;
        try (PreparedStatement getLockersSql = conn.prepareStatement("SELECT * FROM lockers WHERE location = ?")) {
            getLockersSql.setString(1,location);
            ResultSet resultSet = getLockersSql.executeQuery();
            while (resultSet.next()){
                Locker lock = new Locker();
                lock.setId(resultSet.getInt("id"));
                lock.setLocation(resultSet.getString("location"));
                lock.setAddress(resultSet.getString("address"));
                results.add(lock);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return Optional.ofNullable(results);
    }

    public ArrayList<Locker> getLockersByLocation(String location){
        ArrayList<Locker> results = new ArrayList<>();
        try (  Statement stmt = conn.createStatement()) {
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

    public ArrayList<Locker> getLockersByLocation2(String location){
        ArrayList<Locker> results = new ArrayList<>();
        try (PreparedStatement getLockersSql = conn.prepareStatement("SELECT * FROM lockers WHERE location = ?")) {
            getLockersSql.setString(1,location);
            ResultSet resultSet = getLockersSql.executeQuery();
            while (resultSet.next()){
                Locker lock = new Locker();
                lock.setId(resultSet.getInt("id"));
                lock.setLocation(resultSet.getString("location"));
                lock.setAddress(resultSet.getString("address"));
                results.add(lock);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return results;
    }

    public boolean updateLocker(Locker locker) {
        try {
            Statement stmt = conn.createStatement();
            String selectLocker = "UPDATE lockers SET address='" + locker.getAddress() +
                    "' WHERE location='" +
                    locker.getLocation() +
                    "'";
            System.out.println(selectLocker);
            int result = stmt.executeUpdate(selectLocker);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean updateLocker2(Locker locker) {
        try (PreparedStatement updateLockerSql = conn.prepareStatement("UPDATE lockers SET address = ? WHERE location = ?")) {
            updateLockerSql.setString(1, locker.getAddress());
            updateLockerSql.setString(2, locker.getLocation());
            updateLockerSql.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<Ball> getAllBallsByJoin() {
        ArrayList<Ball> results = new ArrayList<>();
        try (CallableStatement getAllBallsSql = conn.prepareCall ("{call get_balls ()}")) {
            ResultSet resultSet = getAllBallsSql.executeQuery();
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
    public void insertBallInExistingLocker(){
        Locker locker = getLockerById(2);

        Ball ball = new Ball();
        ball.setType("Ball With Locker");
        ball.setNeedsAir(false);
        ball.setReplace(false);
        ball.setLocation(locker);

        this.buyNewBall(ball);
    }

    public void insertBallInNewLocker(){
        Locker locker = new Locker();
        locker.setLocation("new Location");

        Ball ball = new Ball();
        ball.setType("Ball Without Locker");
        ball.setNeedsAir(false);
        ball.setReplace(false);
        ball.setLocation(locker);

        this.buyNewBall(ball);
    }
    public void buyNewBall(Ball ball){
        try (PreparedStatement insertLockerSql=conn.prepareStatement(
                "INSERT INTO lockers(location) VALUES(?)");
             PreparedStatement insertBallSql=conn.prepareStatement("INSERT INTO " +
                     "equipmentBall(type, needsAir, location) VALUES(?,?,?)"); ) {
            conn.setAutoCommit(false);
            if(ball.getLocation().getId()==-1) {
                insertLockerSql.setString(1,ball.getLocation().getLocation());
                insertLockerSql.executeUpdate();
            }
            int needsAir = (ball.needsAir()) ? 1 : 0;
            insertBallSql.setString(1,ball.getType());
            insertBallSql.setInt(2, needsAir);
            insertBallSql.setInt(3, ball.getLocation().getId());
            insertBallSql.executeUpdate();
            if(ball.getLocation().getId()==-1) {
                conn.rollback();
            } else {
                conn.commit();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }


}
