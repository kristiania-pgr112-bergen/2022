package LectureCode.Session4.src;

public class Teacher {
    /**
     * static variables and Getters/Setters
     */
    static String subject;
    public static String getSubject() {
        return subject;
    }
    public static void setSubject(String subject) {
        Teacher.subject = subject;
    }
    /**
     * static method cannot access non-static variables
     * To access non-static variables, you need to create an object instance
     */
    public static void printTeacherSubject() {
        Teacher teacher = new Teacher();
        teacher.setSubject("IT Technology");
        System.out.println("Teacher subject:"+teacher.subject);
    }
    /**
     * Object method can access static variable
     */
    public void printSubject() {
        System.out.println("Subject:"+subject);
    }
}
