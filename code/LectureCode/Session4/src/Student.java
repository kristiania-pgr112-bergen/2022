package LectureCode.Session4.src;
import LectureCode.Session4.src.package0.*;

/**
 * Student class is a child class of Person, and reside in the same package as PrintStudent class
 * Fields:
 *      - protected studentId
 *  Methods:
 *      - protected printName()
 *      - public printStudent()
 *      - override printClassName()
 *      - implementation of abstract method printAll()
 */
public class Student extends Person{
    /**
     * studentId is a protected variable but accessible by PrintStudent class since they reside in the same package
     */
    protected int studentId=0;

    /**
     * This constructor calls Person.getSsn and Person constructor, both are protected methods
     */

    public Student(String ssn, int studentId) {
        super(ssn);
        System.out.println("ssn is " + this.getSsn());
        this.studentId = studentId;
    }

    /**
     *      printStudentSsn() is a protected method but can be called directly by GenericClass class
     *      since they reside in the same package
     *      In this method, printSsn are defined/implemented in Person class
     *      Student is a child class of Person, so it can access both methods
     */
    protected void printStudentSsn() {
        printSsn();
    }

    /**
     * override method since printClassName is implemented in Person class
     */
    @Override
    public void printClassName() {
        System.out.println("This is Student class");
    }

    /**
     * printAll method is implemented in Student class
     * Person class only define it as an abstract method
     * ssn is protected attribute in Person but can be directly accessed by Student
     */
    public void printAll(){
        System.out.println(
                " student Id:"+studentId+
                " ,ssn:"+ssn);
    }


}
