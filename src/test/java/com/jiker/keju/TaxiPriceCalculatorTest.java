package com.jiker.keju;

import org.junit.Test;
import static org.junit.Assert.*;

public class TaxiPriceCalculatorTest {

    @Test
    public void distance_2_wait_0() {
        TaxiPriceCalculator priceCalculator = new TaxiPriceCalculator();
        double price = priceCalculator.getPrice(2, 0);
        assertEquals(6, price, 2);
    }

    @Test
    public void distance_3_wait_0() {
        TaxiPriceCalculator priceCalculator = new TaxiPriceCalculator();
        double price = priceCalculator.getPrice(3, 0);
        assertEquals(6.8, price, 2);
    }

    @Test
    public void distance_10_wait_0() {
        TaxiPriceCalculator priceCalculator = new TaxiPriceCalculator();
        double price = priceCalculator.getPrice(10, 0);
        assertEquals(13.2, price, 2);
    }

    @Test
    public void distance_2_wait_3() {
        TaxiPriceCalculator priceCalculator = new TaxiPriceCalculator();
        double price = priceCalculator.getPrice(2, 3);
        assertEquals(6.75, price, 2);
    }
}
