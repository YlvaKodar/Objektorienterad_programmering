package Sprint2.GeometriskaFigurer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TriangleTest {

    Triangle triangle = new Triangle(6, 5);
    @Test
    void getAreatest(){
        assertTrue(triangle.getArea() == 15);
        assertFalse(triangle.getArea() == 14);
    }
    @Test
    void getCircumference(){
        assertTrue(triangle.getCircumference() == 15);
        assertFalse(triangle.getCircumference() == 14);
    }
}