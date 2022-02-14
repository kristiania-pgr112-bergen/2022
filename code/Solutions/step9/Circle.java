package Solutions.step9;

import java.awt.*;

public class Circle extends Shape {
    final MovablePoint center;

    private double radius;

    /*
        Let's have only one constructor. We require that all fields are populated through constructor.
        We now have no alternative options when creating a circle object.
     */
    public Circle(MovablePoint center, int radius, Color color, boolean filled) {
        super(color,filled);
        this.radius = radius;
        this.center = center;
    }

    //Getter for radius
    public double getRadius() {
        return radius;
    }

    //Setter for radius
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /*
        We override the abstract method getArea in Shape.
        If we do not do this, this class (Circle) must be abstract as we are missing
        implementation details for an abstract method defined in class Shape.
     */
    @Override
    public double getArea() {
        return (radius*radius)*Math.PI;
    }

    /*
        We override the abstract method getPerimeter in Shape.
        If we do not do this, this class (Circle) must be abstract as we are missing
        implementation details for an abstract method defined in class Shape.
     */
    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    public void moveUp(double distance) {
        this.center.moveUp(distance);
    }

    public void moveDown(double distance) {
        this.center.moveDown(distance);
    }

    public void moveLeft(double distance) {
        this.center.moveLeft(distance);
    }

    public void moveRight(double distance) {

    }

    /*
        We override a method from the Object class.
        Remember that all classes inherit from the Object class.
        It is normal to override this method as the method
        inherited from Object provides little information.
     */
    @Override
    public String toString() {
        // Using the String class static method "format" as an alternative string concatenation.
        return String.format("A Circle with radius = %s, which is a subclass of %s",
                radius, super.toString()); // Look! I can call my parent version of toString:)
    }
}