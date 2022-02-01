package LectureCode.Session8.src.staticexamples;

public class Main {
    public static void main(String args[]){
        Student student1 = new Student(123, "student1");
        Student student2 = new Student(321, "student2");
        student1.setCollege("OsloMet");
        student1.printState();
        student2.printState();
        Student.setCollege("UiO");
        student1.printState();
        student2.printState();

    }
}
