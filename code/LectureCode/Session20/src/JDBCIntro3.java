package LectureCode.Session20.src;

public class JDBCIntro3 {
    public static void main(String[] args) {

        /**
         * SQL injection
         */

        JDBCInjection jdbcInjection = new JDBCInjection();
        //jdbcInjection.trickyInjection1(new JDBCOps());
        jdbcInjection.trickyInjection2(new JDBCOps2());
    }
}
