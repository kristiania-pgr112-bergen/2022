package LectureCode.Session8.src.AbstractExample;

public class Main {
    public static void main(String[] args) {
        Rectangle square = new Square(1, 1.5);
        square.myOperations();
        square.setLineWeightForMe(2.0);
        System.out.println(square);
    }
}
