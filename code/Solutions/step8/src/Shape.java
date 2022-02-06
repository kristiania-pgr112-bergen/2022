package Solutions.step8.src;

import java.awt.*;

public abstract class Shape {

    private Color color;
    private boolean filled;
    private final int id;

    public Shape(int id){
        this.id = id;
        this.color=Color.RED;
        this.filled=true;
    }

    public Shape(int id, Color color, boolean filled){
        this.id = id;
        this.color=color;
        this.filled=filled;
    }

    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public String toString(){
        if(this.isFilled()) {
            return String.format("A Shape with color of %s, id=%s and filled.", color.toString(), id);
        }
        return String.format("A Shape with color of %s, id=%s and not filled.", color.toString(), id);
    }

}