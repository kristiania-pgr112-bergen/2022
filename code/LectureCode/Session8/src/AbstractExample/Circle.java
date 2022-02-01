package LectureCode.Session8.src.AbstractExample;

public class Circle extends Shape{
    private double radius;

    /**
     * abstract class can also have constructor
     *
     * @param Id
     */
    public Circle(int Id, double radius) {
        super(Id);
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2*radius*Math.PI;
    }

    @Override
    public String toString() {
        return String.format("A Circle is created, whose id is %d, and is a subclass of %s", getId(), super.toString());
    }
}
