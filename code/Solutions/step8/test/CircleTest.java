package Solutions.step8.test;

import Solutions.step8.src.Circle;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CircleTest {

    @Test
    void createCircleEmptyConstructor() {
        Circle circle = new Circle(1);
        assertTrue(circle.isFilled());
        assertEquals(circle.getRadius(), 1.0);
        assertEquals(Color.RED, circle.getColor());
        assertEquals(circle.getId(), 1);
    }

    @Test
    void createCircleRadiusConstructor() {
        Circle circle = new Circle(2, 2.0);
        assertTrue(circle.isFilled());
        assertEquals(circle.getRadius(), 2.0);
        assertEquals(Color.RED, circle.getColor());
        assertEquals(circle.getId(), 2);
    }
    @Test
    void createCircleFullConstructor() {
        Circle circle = new Circle(1, 2.0);
        assertTrue(circle.isFilled());
        assertEquals(circle.getRadius(), 2.0);
        assertEquals(Color.RED, circle.getColor());
        assertEquals(circle.getId(), 1);
    }


    @Test
    void getPerimeter() {
        Circle circle = new Circle(2, 2.0);
        assertEquals(4.0 * Math.PI, circle.getPerimeter());
    }

    @Test
    void getArea() {
        Circle circle = new Circle(3, 3.0);
        assertEquals(Math.PI * 3.0 * 3.0, circle.getArea());
    }

}