package LectureCode.Session20.src;

import LectureCode.Session20.src.equipment.Ball;
import LectureCode.Session20.src.equipment.Locker;

import java.util.ArrayList;

public class JDBCIntro2 {
    static ArrayList<Locker> lockers = new ArrayList<>();
    static ArrayList<Ball> balls = new ArrayList<>();
    public static void main(String[] args) {
        /**
         * preparedStatement, callableStatement
         */
        JDBCOps2 jdbcOps2 = new JDBCOps2();
        createTable(jdbcOps2);
        generateAndInsertLockers(jdbcOps2);
        lockers = jdbcOps2.getAllLockers();
        generateAndInsertBalls(jdbcOps2);
        balls = jdbcOps2.getAllBallsByJoin();
        balls.forEach(ball -> System.out.println(ball));
        String location = jdbcOps2.getBallLocationById(10);
        System.out.println("The ball location with ID: 10 is " + location);
        String location2 = jdbcOps2.getBallLocationById2(10);
        System.out.println("The ball location with ID: 10 is " + location2);

        /**
         * transaction, committment, rollback
         */
        jdbcOps2.insertBallInNewLocker();
        jdbcOps2.insertBallInExistingLocker();

    }
    public static void createTable(JDBCOps2 ops){
        ops.createTable();
    }

    public static void generateAndInsertLockers(JDBCOps2 ops){
        for (int i = 0; i < 10; i++){
            Locker lock = new Locker();
            lock.setLocation("Locker " + i);
            boolean result = ops.insertLocker(lock);
            if(result) System.out.println("successfully inserted :" + lock.getLocation());
        }
    }

    public static void generateAndInsertBalls(JDBCOps2 ops){
        int lockerIndex = 0;
        for (int i = 0; i < 20; i++){
            Ball ball = new Ball();
            ball.setType(Ball.getRandomType());
            ball.setNeedsAir(false);
            ball.setLocation(lockers.get(lockerIndex));
            if(lockerIndex >= 9) lockerIndex = 0;
            else lockerIndex++;
            ops.insertBall(ball);
        }

    }


}
