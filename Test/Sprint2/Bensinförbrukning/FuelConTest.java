package Sprint2.Bensinförbrukning;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FuelConTest {
    FuelCon fuelCon = new FuelCon();
    @Test
    void meterDifferenceTest(){
        assertTrue(fuelCon.meterDifference(200,100) == 100);
        assertFalse(fuelCon.meterDifference(200,100) == 0);
    }
    @Test
    void gasPerMileTest(){
        assertTrue(fuelCon.gasPerMile(100, 100) == 1);
        assertFalse(fuelCon.gasPerMile(100, 100) == 10);
    }
    @Test
    void milesDrivenTest(){
        assert(fuelCon.milesDriven(100).contains("100"));
        assert(!fuelCon.milesDriven(100).contains("200"));
    }
    @Test
    void gasUsedTest(){
        assert(fuelCon.gasUsed(100).contains("100"));
        assert(!fuelCon.gasUsed(100).contains("200"));
    }
    @Test
    void gasPerMile(){
        assert(fuelCon.gasPerMile(1).contains("1"));
        assert(!fuelCon.gasPerMile(1).contains("200"));
    }
}