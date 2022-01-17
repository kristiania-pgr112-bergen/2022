package LectureCode.Session4.src.package0;
/**
 *  Person-class
 *  - it is an abstract class
 *
 *  Fields:
 *  - protected ssn
 *
 *  Methods:
 *  - public getter/Setters for ssn
 *  - protected printperson()
 *  - public printPerson()
 *  - abstract printAll()
 */


abstract public class Person {
    /**
     * protected fields
     */
    protected String ssn;

    /**
     *    protected Getter/Setters for ssn
     */

    protected String getSsn() {
        return ssn;
    }
    protected Person(String ssn) {
        this.ssn = ssn;
    }

    /**
     *  protected method
     *  printStatus() can not be called directly by GenericClass class since they reside in different packages
     *  GenericClass class must use printPerson() through child classes, i.e., Student class
      */

    protected void printSsn() {
        System.out.println(
                "ssn:" + ssn
        );
    }

    //inheritance
    public void printClassName() {
        System.out.println("This is Person class");
    }
    // abstract method. Need to be implemented by the child class
    abstract public void printAll();

}
