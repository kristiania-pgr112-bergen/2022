package LectureCode.Session20.src;


import LectureCode.Session20.src.equipment.Ball;
import LectureCode.Session20.src.equipment.Locker;

import java.util.ArrayList;

public class JDBCIntro {
    static ArrayList<Locker> lockers = new ArrayList<>();
    static ArrayList<Ball> balls = new ArrayList<>();
    public static void main(String[] args) {
        JDBCOps jdbcOps = new JDBCOps();
        createTable(jdbcOps);
        generateAndInsertLockers(jdbcOps);
        lockers = jdbcOps.getAllLockers();
        generateAndInsertBalls(jdbcOps);
        balls = jdbcOps.getAllBallsByJoin();
        balls.forEach(ball -> System.out.println(ball));
    }

    public static void createTable(JDBCOps ops){
        ops.createTable();
    }

    public static void generateAndInsertLockers(JDBCOps ops){
        for (int i = 0; i < 10; i++){
            Locker lock = new Locker();
            lock.setLocation("Locker " + i);
            boolean result = ops.insertLocker(lock);
            if(result) System.out.println("successfully inserted :" + lock.getLocation());
        }
    }

    public static void generateAndInsertBalls(JDBCOps ops){
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
