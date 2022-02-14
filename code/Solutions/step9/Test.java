package Solutions.step9;

import java.awt.*;
import java.util.ArrayList;

/**
 * Test is a class for testing purposes.
 * We test if the assignments work as intended.
 */
public class Test {
    /**
     * A dummy method to check if the program is working
     * initially after importing files from Canvas.
     */
    public void checkIfEverythingOk() {
        Circle circle = new Circle(
                new MovablePoint(2, 2),
                2,
                Color.RED,
                true
        );

        Rectangle rectangle = new Rectangle(
                new MovablePoint(0, 6),
                new MovablePoint(6, 0),
                6,
                6,
                Color.GREEN,
                true
        );

        Square square = new Square(
                new MovablePoint(8, 4),
                new MovablePoint(4, 8),
                4,
                Color.BLUE,
                true
        );

        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(square);

        // print each shape's state
        // move all shapes 2 units to the right
        // print and compare

        for (Shape shape : shapes) {
            this.printShapeInfo(shape);

            shape.moveRight(10);
            this.printShapeInfo(shape);

            shape.moveLeft(10);
            this.printShapeInfo(shape);

            System.out.println("---");
        }
    }

    void printShapeInfo(Shape shape) {
        System.out.println(shape.toString());

        if (shape instanceof Circle) {
            System.out.println(((Circle) shape).center);
        }
        else if (shape instanceof Rectangle) {
            // also handles Square
            System.out.println(((Rectangle) shape).corners[0]);
            System.out.println(((Rectangle) shape).corners[1]);
        }
    }
}
