package LectureCode.step4.src.org.pgr112.lecture.test;

abstract public class Person {
    protected String ssn;

    protected String getSsn() {
        return ssn;
    }

    protected Person(String ssn) {
        this.ssn = ssn;
    }
    abstract public void printClassName();
}
