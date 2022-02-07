import java.awt.*;

public class Square extends Rectangle {

    /*
        Let's have only one constructor. We require that all fields are populated through constructor.
        We now have no alternative options when creating a square object.
        Notice how we use side as both width and length when we call the parent constructor.
     */
    public Square(double side, Color color, boolean filled) {
        super(side, side, color, filled);
    }

    // Getter for side
    public double getSide(){
        /*
            We inherit from parent class (Rectangle), and as all sides in a square have the same
            length, we can return either length or width inherited from parent.
            That is nice! We do not need a field for side in Square:)
            But as the fields in the parent are private, we may not access the fields directly.
            But the getters (getLength and getWidth) are public, and therefore accessible.
         */
        return super.getLength();
    }

    // Setter for side
    public void setSide(double side){
        /*
            Notice how we set both length and width inherited from Rectangle.
         */
        super.setLength(side);
        super.setWidth(side);
    }

    /*
        We override a method from the Object class.
        Remember that all classes inherit from the Object class.
        It is normal to override this method as the method
        inherited from Object provides little information.
     */
    public String toString(){
        return "A Square with side = " + this.getSide() +", which is a subclass of " + super.toString();
    }

    /*
        Where are the methods for getArea and getPerimeter?
        We do not need to override them as calculating
        area and perimeter is the same for squares as for rectangles.
        And these methods are already implemented in the Rectangle (parent) class.
     */

}