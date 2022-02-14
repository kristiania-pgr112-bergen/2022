package Solutions.step9;

import java.awt.*;

public class Rectangle extends Shape {

    private double width;
    private double length;

    /**
     * 0: topLeft
     * 1: bottomRight
     */
    final MovablePoint[] corners = new MovablePoint[2];

    /*
        Let's have only one constructor. We require that all fields are populated through constructor.
        We now have no alternative options when creating a rectangle object.
     */
    Rectangle(
            MovablePoint topLeft,
            MovablePoint bottomRight,
            double width,
            double length,
            Color color,
            boolean filled
    ) {
        super(color, filled);
        this.corners[0] = topLeft;
        this.corners[1] = bottomRight;
        this.width = width;
        this.length = length;
    }

    // Getter for width
    public double getWidth() {
        return width;
    }

    // Setter for width
    public void setWidth(double width) {
        this.width = width;
    }

    // Getter for length
    public double getLength() {
        return length;
    }

    // Setter for length
    public void setLength(double length) {
        this.length = length;
    }

    /*
        We override the abstract method getArea in Shape.
        If we do not do this, this class (Rectangle) must be abstract as we are missing
        implementation details for an abstract method defined in class Shape.
    */
    public double getArea() {
        return getLength() * getWidth();
    }

    /*
        We override the abstract method getPerimeter in Shape.
        If we do not do this, this class (Rectangle) must be abstract as we are missing
        implementation details for an abstract method defined in class Shape.
    */
    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    public void moveUp(double distance) {
        this.corners[0].moveUp(distance);
        this.corners[1].moveUp(distance);
    }

    public void moveDown(double distance) {
        this.corners[0].moveDown(distance);
        this.corners[1].moveDown(distance);
    }

    public void moveLeft(double distance) {
        this.corners[0].moveLeft(distance);
        this.corners[1].moveLeft(distance);
    }

    public void moveRight(double distance) {
        this.corners[0].moveRight(distance);
        this.corners[1].moveRight(distance);
    }

    /*
        We override a method from the Object class.
        Remember that all classes inherit from the Object class.
        It is normal to override this method as the method
        inherited from Object provides little information.
     */
    public String toString() {
        return "A Rectangle with width = " + width + " and length = " +
                length + ", which is a subclass of " + super.toString();
    }

}