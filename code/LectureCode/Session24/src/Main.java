package LectureCode.Session24.src;

import LectureCode.Session24.src.equipment.Ball;
import LectureCode.Session24.src.equipment.Locker;

import java.util.ArrayList;

public class Main {
    static ArrayList<Locker> lockers = new ArrayList<>();
    static ArrayList<Ball> balls = new ArrayList<>();
    static JDBCOps jdbcOps = new JDBCOps();
    public static void main(String[] args) {
        jdbcOps.generateAndInsertLockers();
        jdbcOps.generateAndInsertBalls();

        trickyOperation();
        trickyInjection();
    }

    public static void trickyOperation() {
        /**
         * transaction, committment, rollback
         */
        jdbcOps.insertBallInNewLocker();
        jdbcOps.insertBallInExistingLocker();

        balls = jdbcOps.getAllBallsByJoin();
        balls.forEach(ball -> System.out.println(ball));
    }

    public static void trickyInjection() {
        /**
         * using basic statement
         */
        //Getting all lockers
        System.out.println("Getting all lockers");
        ArrayList<Locker> lockersByLocation = jdbcOps.getLockersByLocation("Locker 0' or '1' = '1");
        lockersByLocation.forEach(l -> System.out.println(l));

        // Potentially dropping tables
        System.out.println("Potentially dropping tables");
        Locker locker = new Locker();
        locker.setLocation("Locker 1'; DROP TABLE equipmentBall; -- 'comment");
        locker.setAddress("Modified address");
        jdbcOps.updateLocker(locker);
        ArrayList<Ball> getAllBalls = jdbcOps.getAllBallsByJoin();
        getAllBalls.forEach(b -> System.out.println(b));


        /**
         * using preparedStatement
         */
        //Getting all lockers
        System.out.println("Getting all lockers");
        ArrayList<Locker> lockersByLocation2 = jdbcOps.getLockersByLocation2("Locker 0' or '1' = '1");
        lockersByLocation2.forEach(l -> System.out.println(l));

        // Potentially dropping tables
        System.out.println("Potentially dropping tables");
        Locker locker2 = new Locker();
        locker2.setLocation("Locker 1'; DROP TABLE equipmentBall; -- 'comment");
        locker2.setAddress("Modified address");
        jdbcOps.updateLocker2(locker2);

        getAllBalls = jdbcOps.getAllBallsByJoin();
        getAllBalls.forEach(b -> System.out.println(b));

    }

}
