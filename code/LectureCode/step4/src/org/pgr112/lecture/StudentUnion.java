package LectureCode.step4.src.org.pgr112.lecture;

public class StudentUnion {
    private String name;
    private int yearlyFee;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearlyFee() {
        return yearlyFee;
    }

    public void setYearlyFee(int yearlyFee) {
        this.yearlyFee = yearlyFee;
    }

    public StudentUnion(String name, int yearlyFee) {
        this.name = name;
        this.yearlyFee = yearlyFee;
    }
    public void printUnion() {
        System.out.println(
                "union name: "+name +
                ", yearly fee:"+yearlyFee
        );
    }
}
