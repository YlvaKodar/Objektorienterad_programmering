package Sprint2.Change;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ChangeCalculatorTest {

    protected int price = 850;
    protected int amountReceived = 2000;


    ChangeCalculator ch = new ChangeCalculator( price, amountReceived);

    @Test
    void expectedChangeTest(){
        assertEquals(ch.expectedChange(amountReceived, price),1150);
        assertFalse(ch.expectedChange(amountReceived, price) == 2150);
    }
    @Test
    void reactToAmountReceivedTest(){
        assertEquals(ch.reactToAmountReceived(),"\nPrice of item: " + price + " kr. \nAmount received: " + amountReceived + " kr. \nChange: " + ch.expectedChange(amountReceived, price) + " kr.\n");
        assertFalse(ch.reactToAmountReceived().contains("No change."));
    }
    @Test
    void valueCounter(){
        int[] i = {1000, 1};
        assertArrayEquals(i, ch.valueCounter(1000));
    }
//    @Test
//    void getListOfChangeTest(){
//
//    }
}