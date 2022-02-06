package Solutions.step8.src;

import java.awt.*;

public class Rectangle extends Shape {

    private double width;
    private double length;

    public Rectangle(int id){
        super(id, Color.GREEN, true);
        this.width=1.0;
        this.length=2.0;
    }

    public Rectangle(int id, double width, double length){
        super(id, Color.GREEN, true);
        this.width=width;
        this.length=length;
    }

    public Rectangle(int id, double width, double length, Color color, boolean filled){
        super(id, color,filled);
        this.width=width;
        this.length=length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }


    public double getArea(){
        return length*width;
    }

    public double getPerimeter(){
        return 2*(length+width);
    }

    public String toString(){
        return "A Rectangle with width = "+ width + " and length = "+ length +", which is a subclass of " + super.toString();
    }

}