package com.pdubrov.shopping;

import org.junit.Assert;
import org.junit.Test;

public class DefaultPricingStrategyTest {

    @Test
    public void testTotalPriceIsCorrectWhenBothArePositive(){
        DefaultPricingStrategy dps = new DefaultPricingStrategy();
        int totalPrice = dps.price( 2, 3);
        Assert.assertEquals( 6, totalPrice);
    }

    @Test
    public void testTotalPriceIsZeroWhenQuantityIsZero(){
        DefaultPricingStrategy dps = new DefaultPricingStrategy();
        int totalPrice = dps.price( 0, 3);
        Assert.assertEquals( 0, totalPrice);
    }

    @Test( expected = IllegalArgumentException.class)
    public void testPriceThrowsErrorWhenQuantityIsNegative(){
        DefaultPricingStrategy dps = new DefaultPricingStrategy();
        int totalPrice = dps.price( -2, 3);
    }

    @Test( expected = IllegalArgumentException.class)
    public void testPriceThrowsErrorWhenUnitPriceIsNegative(){
        DefaultPricingStrategy dps = new DefaultPricingStrategy();
        int totalPrice = dps.price( 2, -3);
    }
}
