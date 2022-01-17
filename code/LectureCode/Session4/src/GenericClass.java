package LectureCode.Session4.src;

public class GenericClass {
    public static void main(String[] args) {
        /**
         * printStudentSsn() is a protected method defined in Student class and can be called directly
         * it calls protected Person.printSsn()
         */
        Student student = new Student("1234567890", 146);
        student.printStudentSsn();

        /**
         * test inheritance
         * What is the output for student.printClassName() since this method is overriden?
         * What is the output for student.printAll() since this method is implemented inside Student class?
         */
        student.printClassName();
        student.printAll();

        /**
         * test static
         */
        Teacher teacher1 = new Teacher();
        teacher1.setSubject("IT Technology");
        Teacher teacher2 = new Teacher();
        teacher2.setSubject("E-Business");
        System.out.println("Call teacher1.printSubject()...");
        teacher1.printSubject();
        System.out.println("Call teacher2.printSubject()...");
        teacher2.printSubject();


        /**
         * printTeacherSubject() is a static method. It can be called by either class or object instance
         */
        System.out.println("Call printTeacherSubject() from object instance...");
        teacher1.printTeacherSubject();

        System.out.println("Call printTeacherSubject() from Class...");
        Teacher.printTeacherSubject();

        System.out.println("Call teacher2.printSubject()...");
        teacher2.printSubject();
    }

}
