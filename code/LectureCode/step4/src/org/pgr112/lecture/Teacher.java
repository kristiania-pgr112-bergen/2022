package LectureCode.step4.src.org.pgr112.lecture;

import LectureCode.step4.src.org.pgr112.lecture.test.Person;

public class Teacher extends Person {
    static private String subject;
    private int employeeNumber;

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    protected Teacher(String ssn) {
        super(ssn);
    }

    public static String getSubject() {
        return subject;
    }

    public static void setSubject(String subject) {
        Teacher.subject = subject;
    }
    public void printSubject() {
        System.out.println(subject);
    }

    public static void printTeacherInfo() {
        Teacher teacher = new Teacher("111");
        teacher.setEmployeeNumber(001);
        System.out.println(
                "ssn: "+teacher.getSsn() +
                " ,subject: "+teacher.getSubject() +
                " ,employeeNumber: "+teacher.getEmployeeNumber()
        );
    }

    @Override
    public void printClassName() {
        String className = this.getClass().getName();
        System.out.println(className);
    }
}
