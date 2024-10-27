package Sprint2.GeometriskaFigurer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SquareTest {
    Square square = new Square(5, 3);

    @Test
    void getAreatest(){
        assertTrue(square.getArea() == 15);
        assertFalse(square.getArea() == 14);
    }

    @Test
    void getCircumference(){
        assertTrue(square.getCircumference() == 16);
        assertFalse(square.getCircumference() == 14);
    }
}