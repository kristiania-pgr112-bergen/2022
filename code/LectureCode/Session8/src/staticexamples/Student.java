package LectureCode.Session8.src.staticexamples;

public class Student {
    int studentId;//instance variable
    String name;

    static String college ="Høyskole Kristiania";//static variable

    public static String getCollege() {
        return college;
    }

    public static void setCollege(String college) {
        Student.college = college;
    }

    /**
     * constructor
     * note that the static String college can not be enrolled in constructor. why?
     */
    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    /**
     * note that static field can be accessed via instance..but we recommend not..
     */
    void printState(){
        System.out.println(this.studentId+" "+ this.name+" "+ college);
    }
    public static void printCollege() {
        System.out.println(college);
    }

    /**
     * note that static method can not access non-static field
     */
    public static void printAll() {
        Student student = new Student(123, "Ole");
        System.out.println(student.studentId+" "+ student.name+" "+ college);
    }

}
