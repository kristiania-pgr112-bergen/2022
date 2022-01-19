package LectureCode.step4.src.org.pgr112.lecture;

import LectureCode.step4.src.org.pgr112.lecture.test.Person;

import java.util.ArrayList;
import java.util.Optional;

public class Student extends Person {
    protected int studentId;
    private Campus campus;
    private ArrayList<StudentUnion> unions;

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * constructor
     * @param ssn
     * @param studentId
     */
    protected Student(String ssn, int studentId) {
        super(ssn);
        this.studentId=studentId;
    }

    public Student(String ssn, int studentId, Campus campus) {
        this(ssn, studentId);
        this.campus = campus;
    }

    public Student(String ssn, int studentId, Campus campus, ArrayList<StudentUnion> unions) {
        this(ssn, studentId,campus);
        this.unions = unions;
    }

    protected void printSsn() {
        System.out.println(this.getSsn());
    }

    @Override
    public void printClassName() {
        String className = this.getClass().getName();
        System.out.println(className);
    }

    public void printAll() {
        System.out.println(
                "studentId: "+ studentId +
                " ,campus: "+campus.getLocation()
        );
    }
    public void printUnions() {
        /**
         * how shall we prevent nullpointer exception when unions is null?
         */
/*        if (unions != null && !unions.isEmpty()) {
            for (StudentUnion union : unions) {
                union.printUnion();
            }
        }*/
        /**
         * another method
         */
        for (StudentUnion union :
                Optional.ofNullable(unions).orElse(new ArrayList<>())) {
            union.printUnion();
        }
    }
}
