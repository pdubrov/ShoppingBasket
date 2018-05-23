package com.pdubrov.shopping;

import org.junit.Assert;
import org.junit.Test;

public class BuyXGetYFreePricingStrategyTest {

    @Test( expected = IllegalArgumentException.class)
    public void testStrategyCanNotBeCreatedWithNegativeQuantityToBuy(){
        BuyXGetYFreePricingStrategy dps = new BuyXGetYFreePricingStrategy( -2,1);
    }

    @Test( expected = IllegalArgumentException.class)
    public void testStrategyCanNotBeCreatedWithNegativeQuantityToGetForFree(){
        BuyXGetYFreePricingStrategy dps = new BuyXGetYFreePricingStrategy( 2,-1);
    }

    @Test
    public void testTotalPriceIsCorrectWhenBothArePositive(){
        BuyXGetYFreePricingStrategy dps = new BuyXGetYFreePricingStrategy( 2,1);
        int totalPrice = dps.price( 16, 3);
        Assert.assertEquals( 33, totalPrice);
    }

    @Test
    public void testTotalPriceIsZeroWhenQuantityIsZero(){
        BuyXGetYFreePricingStrategy dps = new BuyXGetYFreePricingStrategy(2, 1);
        int totalPrice = dps.price( 0, 3);
        Assert.assertEquals( 0, totalPrice);
    }

    @Test( expected = IllegalArgumentException.class)
    public void testPriceThrowsErrorWhenQuantityIsNegative(){
        BuyXGetYFreePricingStrategy dps = new BuyXGetYFreePricingStrategy(2, 1);
        int totalPrice = dps.price( -2, 3);
    }

    @Test( expected = IllegalArgumentException.class)
    public void testPriceThrowsErrorWhenUnitPriceIsNegative(){
        BuyXGetYFreePricingStrategy dps = new BuyXGetYFreePricingStrategy(2, 1);
        int totalPrice = dps.price( 2, -3);
    }
}
