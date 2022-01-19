package LectureCode.step4.src.org.pgr112.lecture;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /**
         * test protected, final, abstract
         */
        String ssn= "1234567890";
        int studentId = 123;
        Student student = new Student(ssn, studentId);
        student.printSsn();
        student.printClassName();

/**
 * constructor overloading
 */


        /**
         * create student with unions
         */
        ArrayList<StudentUnion> unions = new ArrayList<>();
        StudentUnion union1 = new StudentUnion("u1", 300);
        StudentUnion union2 = new StudentUnion("u2", 100);
        unions.add(union1);
        unions.add(union2);

        Student student1 = new Student(ssn, studentId, Campus.OSLO);
        student1.printAll();
        student1.printUnions();


        /**
         * test static
         */
        Teacher teacher = new Teacher("1234567890");
        teacher.setSubject("Frontend development");
        teacher.printSubject();

        Teacher teacher1 = new Teacher("1111111111");
        teacher1.setSubject("database");
        /**
        set teacher1 subject, it actually change the shared static subject variable
         */
        teacher.printSubject();
        teacher1.printSubject();

        teacher.printTeacherInfo();

    }
}
