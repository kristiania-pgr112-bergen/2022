package LectureCode.Session10.src.animals;

public class MainecoonBabyCat extends BabyCat{
    public String weight = "1.5kg";

    public MainecoonBabyCat(int id) {
        super(id);
    }
    public void catActivity() {
        System.out.println("The MainecoonBabyCat can chase a mouse, and its weight is " + weight);
    }
    public void printMainecoonBabyCat() {
        System.out.println("I am a mainecoonBabycat");
    }

}
