package Sprint2.Change;

import org.junit.jupiter.api.Test;

class ChangeTest {

    Change c = new Change(500, 2, " kr. notes: ");

    @Test
    void testToString() {
        assert(c.toString().equals("\nQuantity of 500 kr. notes: 2"));
    }
}