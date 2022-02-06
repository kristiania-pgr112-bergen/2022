package Solutions.step8.test;

import org.junit.jupiter.api.Test;
import Solutions.step8.src.Rectangle;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleTest {

    @Test
    void createRectangleEmptyConstructor() {
        Rectangle rectangle = new Rectangle(5);
        assertTrue(rectangle.isFilled());
        assertEquals(rectangle.getLength(), 2.0);
        assertEquals(rectangle.getWidth(), 1.0);
        assertEquals(Color.GREEN, rectangle.getColor());
        assertEquals(rectangle.getId(), 5);
    }

    @Test
    void createRectangleWidthAndLengthConstructor() {
        Rectangle rectangle = new Rectangle(1, 3.0, 4.0);
        assertTrue(rectangle.isFilled());
        assertEquals(rectangle.getLength(), 4.0);
        assertEquals(rectangle.getWidth(), 3.0);
        assertEquals(Color.GREEN, rectangle.getColor());
        assertEquals(rectangle.getId(), 1);
    }
    @Test
    void createRectangleFullConstructor() {
        Rectangle rectangle = new Rectangle(2, 4.0, 5.0, Color.BLUE, false);
        assertFalse(rectangle.isFilled());
        assertEquals(rectangle.getLength(), 5.0);
        assertEquals(rectangle.getWidth(), 4.0);
        assertEquals(Color.BLUE, rectangle.getColor());
        assertEquals(rectangle.getId(), 2);
    }

    @Test
    void getArea() {
        Rectangle rectangle = new Rectangle(2, 3.0, 4.0);
        assertEquals(rectangle.getArea(), 12.0);
    }

    @Test
    void getPerimeter() {
        Rectangle rectangle = new Rectangle(99, 3.0, 4.0);
        assertEquals(rectangle.getPerimeter(), 14.0);
    }
}