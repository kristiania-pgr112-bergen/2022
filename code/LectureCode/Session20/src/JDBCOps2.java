package LectureCode.Session20.src;

import LectureCode.Session20.src.equipment.Ball;
import LectureCode.Session20.src.equipment.Locker;

import java.sql.*;
import java.util.ArrayList;

public class JDBCOps2 {
    public JDBCOps2(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException exception){
            exception.printStackTrace();
        }
    }
    public void createTable() {
        try (Connection conn = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                        "=true&useSSL=false", "user1", "pass")) {
            CallableStatement cstmt = null;
            String SQL = "{call create_table ()}";
            cstmt = conn.prepareCall (SQL);
            cstmt.execute();
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
            PreparedStatement stmt=con.prepareStatement(
                    "INSERT INTO lockers(location) VALUES(?)");
            stmt.setString(1,locker.getLocation());
            stmt.executeUpdate();

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
        return true;
    }
    public ArrayList<Locker> getAllLockers(){
        ArrayList<Locker> results = new ArrayList<>();

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                "=true&useSSL=false", "user1", "pass")) {

            PreparedStatement stmt=con.prepareStatement("SELECT * FROM lockers");
            ResultSet resultSet = stmt.executeQuery();
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

    public static Locker getLockerById(int id){
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                "=true&useSSL=false", "user1", "pass")) {

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM lockers where id=?");
            stmt.setInt(1,id);

            ResultSet resultSet = stmt.executeQuery();
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

    public ArrayList<Locker> getLockersByLocation(String location){
        ArrayList<Locker> results = new ArrayList<>();
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?" +
                "allowPublicKeyRetrieval=true&useSSL=false", "user1", "pass")) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM lockers WHERE location = ?");
            stmt.setString(1,location);
            ResultSet resultSet = stmt.executeQuery();
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

    public boolean updateLocker(Locker locker) {
        /**
         * try-with-resources from Java7
         */
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                        "=true&useSSL=false&allowMultiQueries=true", "user1", "pass")) {
            PreparedStatement stmt = con.prepareStatement("UPDATE lockers SET address = ? WHERE location = ?");
            stmt.setString(1,locker.getAddress());
            stmt.setString(2,locker.getLocation());
            int resultSet = stmt.executeUpdate();
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
            int needsAir = (ball.needsAir()) ? 1 : 0;
            PreparedStatement stmt=con.prepareStatement("INSERT INTO equipmentBall(type, needsAir, location) VALUES(?,?,?)");
            stmt.setString(1,ball.getType());
            stmt.setInt(2, needsAir);
            stmt.setInt(3, ball.getLocation().getId());
            stmt.executeUpdate();
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return result;
    }

    public ArrayList<Ball> getAllBallsByJoin() {
        ArrayList<Ball> results = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                "=true&useSSL=false", "user1", "pass")) {

            CallableStatement cstmt = conn.prepareCall ("{call get_balls ()}");
            ResultSet resultSet = cstmt.executeQuery();
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

    public String getBallLocationById(int id) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                "=true&useSSL=false", "user1", "pass")) {

            CallableStatement cstmt = conn.prepareCall("{call getBallLocation_byId (?,?)}");
            cstmt.setInt(1, id);  // This would set ID
            // Because second parameter is OUT so register it
            cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
            //Use execute method to run stored procedure.
            System.out.println("Executing stored procedure...");
            cstmt.execute();
            String location = cstmt.getString(2);
            return location;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
    public String getBallLocationById2(int id) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                "=true&useSSL=false", "user1", "pass")) {

            CallableStatement cstmt = conn.prepareCall("{?= call getBallLocation_byId2(?)}");
            cstmt.setInt(2, id);
            cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
            System.out.println("Executing stored procedure...");
            cstmt.execute();
            String location = cstmt.getString(1);
            return location;
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
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
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                        "=true&useSSL=false", "user1", "pass")) {
            con.setAutoCommit(false);
            if(ball.getLocation().getId()==-1) {
                PreparedStatement stmt=con.prepareStatement(
                        "INSERT INTO lockers(location) VALUES(?)");
                stmt.setString(1,ball.getLocation().getLocation());
                stmt.executeUpdate();
            }
            int needsAir = (ball.needsAir()) ? 1 : 0;
            PreparedStatement stmt=con.prepareStatement("INSERT INTO " +
                    "equipmentBall(type, needsAir, location) VALUES(?,?,?)");
            stmt.setString(1,ball.getType());
            stmt.setInt(2, needsAir);
            stmt.setInt(3, ball.getLocation().getId());
            stmt.executeUpdate();
            if(ball.getLocation().getId()==-1) {
                con.rollback();
            } else {
                con.commit();
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void buyNewBall2(Ball ball){
        Connection conn = null;
        try {
            conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/equipmentBallsDb?allowPublicKeyRetrieval" +
                            "=true&useSSL=false", "user1", "pass");
            if(ball.getLocation().getId()==-1) {
                PreparedStatement stmt=conn.prepareStatement(
                        "INSERT INTO lockers(location) VALUES(?)");
                stmt.setString(1,ball.getLocation().getLocation());
                stmt.executeUpdate();
            }
            int needsAir = (ball.needsAir()) ? 1 : 0;
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO " +
                    "equipmentBall(type, needsAir, location) VALUES(?,?,?)");
            stmt.setString(1,ball.getType());
            stmt.setInt(2, needsAir);
            stmt.setInt(3, ball.getLocation().getId());
            stmt.executeUpdate();
            if(ball.getLocation().getId()==-1) {
                conn.rollback();
            } else {
                conn.commit();
            }
        }
        catch (Exception ex) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}

