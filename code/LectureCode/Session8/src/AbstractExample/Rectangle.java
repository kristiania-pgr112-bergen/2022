package LectureCode.Session8.src.AbstractExample;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(int Id, double length, double width) {
        super(Id);
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getPerimeter() {
        return 2*(length+width);
    }
    @Override
    public String toString() {
        return String.format("A rectangle is created, whose id is %d, and is a subclass of %s", getId(), super.toString());
    }

}
