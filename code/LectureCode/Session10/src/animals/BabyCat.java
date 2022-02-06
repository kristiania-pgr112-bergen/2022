package LectureCode.Session10.src.animals;

public class BabyCat extends Cat{
    public String weight = "1kg";
    public String babycat = "babycat";
    public BabyCat(int id) {
        super(id);
    }

    public void catActivity() {
        System.out.println("The babycat can chase a mouse, and its weight is " + weight);
    }
    public void printBabyCat() {
        System.out.println("I am a babycat");
    }
}
