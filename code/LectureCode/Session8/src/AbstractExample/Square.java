package LectureCode.Session8.src.AbstractExample;

public class Square extends Rectangle {
    private double perimeter;
    public Square(int Id) {
        super(Id);
    }

    public Square(int Id, double perimeter) {
        super(Id);
        this.perimeter = perimeter;
    }

    /**
     * implement abstract method
     */
    @Override
    public void drawMe() {
        System.out.println("drawing square");
    }

    @Override
    public String toString() {
        return String.format("A Square with perimeter= %f, color = %s, fill = %b, lineWeight = %f " +
                "is created, which is a subclass of %s", perimeter, color, filled, weightOfLine, super.toString());
    }

}
