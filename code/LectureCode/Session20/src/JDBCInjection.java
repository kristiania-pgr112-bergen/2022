package LectureCode.Session20.src;

import LectureCode.Session20.src.equipment.Ball;
import LectureCode.Session20.src.equipment.Locker;

import java.util.ArrayList;

public class JDBCInjection {

    public void trickyInjection1(JDBCOps jdbcOps) {
        ArrayList<Locker> lockers = jdbcOps.getAllLockers();
        ArrayList<Ball> balls = jdbcOps.getAllBallsByJoin();
        balls.forEach(ball -> System.out.println(ball));

        //Getting all lockers
        System.out.println("Getting all lockers");
        ArrayList<Locker> lockersByLocation = jdbcOps.getLockersByLocation("Locker 0' or '1' = '1");
        lockersByLocation.forEach(locker -> System.out.println(locker));

        // Potentially dropping tables
        System.out.println("Potentially dropping tables");
        Locker locker = new Locker();
        locker.setLocation("Locker 1'; DROP TABLE equipmentBall; -- 'comment");
        locker.setAddress("Modified address");
        jdbcOps.updateLocker(locker);
        ArrayList<Ball> getAllBalls = jdbcOps.getAllBallsByJoin();
        getAllBalls.forEach(ball -> System.out.println(ball));

    }

    public void trickyInjection2(JDBCOps2 jdbcOps2) {
/*        ArrayList<Locker> lockers = jdbcOps2.getAllLockers();
        ArrayList<Ball> balls = jdbcOps2.getAllBallsByJoin();
        balls.forEach(ball -> System.out.println(ball));*/

        //Getting all lockers
        System.out.println("Getting all lockers");
        ArrayList<Locker> lockersByLocation1 = jdbcOps2.getLockersByLocation("Locker 0");
        lockersByLocation1.forEach(locker -> System.out.println(locker));
        ArrayList<Locker> lockersByLocation = jdbcOps2.getLockersByLocation("Locker 0' or '1' = '1");
        lockersByLocation.forEach(locker -> System.out.println(locker));

        // Potentially dropping tables
        System.out.println("Potentially dropping tables");
        Locker locker1 = new Locker();
        locker1.setLocation("Locker 1");
        locker1.setAddress("Modified address");
        jdbcOps2.updateLocker(locker1);

        Locker locker = new Locker();
        locker.setLocation("'Locker 1'; DROP TABLE equipmentBall; -- 'comment'");
        locker.setAddress("Modified address");
        jdbcOps2.updateLocker(locker);
/*        ArrayList<Ball> getAllBalls = jdbcOps2.getAllBallsByJoin();
        getAllBalls.forEach(ball -> System.out.println(ball));*/
    }
}
