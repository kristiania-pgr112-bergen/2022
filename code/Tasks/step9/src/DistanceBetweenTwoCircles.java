package Tasks.step9.src;

/**
 *  Session 9 - extra task 3
 *
 *  Use the following code example to finish the method:
 *  - printDistanceBetweenTwoCircles(...)
 *
 *  In this method, calculate the distance, edge to edge, between
 *  the two circles given to the method.
 *
 *  Print out the answer only.
 *
 */

public class DistanceBetweenTwoCircles {
    public static void main(String[] args) {
        Circle A = new Circle();
        Circle B = new Circle();

        A.setRadius(1);
        A.setPosition(10, 10);

        B.setRadius(1);
        B.setPosition(16, 10);

        printDistanceBetweenTwoCircles(A, B);
    }

    static void printDistanceBetweenTwoCircles(Circle A, Circle B) {
        // calculate distance between circle A and B (edge to edge)

        // hint: each circle have a radius
        // hint: distance between the circle, edge to edge
        //       (as in, respect the radius of each circle)
    }
}

class Circle {
    private float radius = 0;
    private float x = 0;
    private float y = 0;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
    }
}
