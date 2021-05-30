package tests;

import Logic.Beverage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeverageTest {
    int beverageID = 1;
    int beveragePrice = 1000;
    Beverage beverage = new Beverage(beverageID, "name", beveragePrice);

    @Test
    public void testGetPrice() {
        assertEquals(beverage.getPrice(), beveragePrice);
    }

    @Test
    public void testGetName() {
        assertEquals(beverage.getName(), "name");
    }
}