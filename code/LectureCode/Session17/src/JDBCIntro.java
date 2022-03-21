package LectureCode.Session17.src;

import LectureCode.Session17.src.equipment.Locker;

import java.sql.SQLException;

public class JDBCIntro {
    public static void main(String[] args) {
        JDBCOps jdbcOps = new JDBCOps();
        //generateAndInsertLockers(jdbcOps);
        createTable(jdbcOps);
        insertEquipmentBalls(jdbcOps);
        updateEquipmentBalls(jdbcOps);
    }

    public static void generateAndInsertLockers(JDBCOps ops){
        for (int i = 0; i < 10; i++){
            Locker lock = new Locker();
            lock.setLocation("Locker " + i);
            boolean result = ops.insertLocker(lock);
            if(result) System.out.println("successfully inserted :" + lock.getLocation());
        }
    }
    public static void createTable(JDBCOps ops){
        boolean result = ops.createTable();
        if(result) System.out.println("table is successfully created");
    }
    public static void insertEquipmentBalls(JDBCOps ops){
        int result = ops.insertEquipmentBalls();
        System.out.println("Rows inserted: "+ result);
    }
    public static void updateEquipmentBalls(JDBCOps ops){
        ops.queryEquipmentBalls();
    }
}
