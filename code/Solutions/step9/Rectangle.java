package Solutions.step9;

import java.awt.*;

public class Rectangle extends Shape {

    private double width;
    private double length;

    /*
        Let's have only one constructor. We require that all fields are populated through constructor.
        We now have no alternative options when creating a rectangle object.
     */
    Rectangle(double width, double length, Color color, boolean filled) {
        super(color, filled);
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
        return length * width;
    }

    /*
        We override the abstract method getPerimeter in Shape.
        If we do not do this, this class (Rectangle) must be abstract as we are missing
        implementation details for an abstract method defined in class Shape.
    */
    public double getPerimeter() {
        return 2 * (length + width);
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