package Solutions.step8.test;

import org.junit.jupiter.api.Test;
import Solutions.step8.src.Square;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareTest {

    @Test
    void createSquareEmptyConstructor() {
        Square square = new Square(7);
        assertTrue(square.isFilled());
        assertEquals(square.getLength(), 1.0);
        assertEquals(square.getWidth(), 1.0);
        assertEquals(Color.GREEN, square.getColor());
        assertEquals(square.getId(), 7);
    }

    @Test
    void createSquareWidthSideConstructor() {
        Square square = new Square(4, 5.0);
        assertTrue(square.isFilled());
        assertEquals(square.getLength(), 5.0);
        assertEquals(square.getWidth(), 5.0);
        assertEquals(Color.GREEN, square.getColor());
        assertEquals(square.getId(), 4);
    }
    @Test
    void createSquareFullConstructor() {
        Square square = new Square(2, 7.0, Color.DARK_GRAY, false);
        assertFalse(square.isFilled());
        assertEquals(square.getLength(), 7.0);
        assertEquals(square.getWidth(), 7.0);
        assertEquals(Color.DARK_GRAY, square.getColor());
        assertEquals(square.getId(), 2);
    }

    @Test
    void getArea() {
        Square square = new Square(1, 5.0);
        assertEquals(square.getArea(), 25.0);
    }

    @Test
    void getPerimeter() {
        Square square = new Square(2, 5.0);
        assertEquals(square.getPerimeter(), 20.0);
    }

}