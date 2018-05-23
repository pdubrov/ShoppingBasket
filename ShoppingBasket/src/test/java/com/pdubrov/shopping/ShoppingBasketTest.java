package com.pdubrov.shopping;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class ShoppingBasketTest {

    @Test
    public void testTotalPriceIsZeroWhenBasketIsEmpty(){
        PriceList priceList = new DefaultPriceList();
        ShoppingBasket shoppingBasket = new ShoppingBasket(priceList);
        List<Product> productList = Collections.emptyList();
        shoppingBasket.addAll(productList);
        int totalPrice = shoppingBasket.getTotalPrice();

        Assert.assertEquals(0, totalPrice );
    }

    @Test
    public void testTotalPriceWhenNoDiscountsOneOfEach(){
        PriceList priceList = new DefaultPriceList();
        ShoppingBasket shoppingBasket = new ShoppingBasket(priceList);
        List<Product> productList = Arrays.asList( Product.APPLE,
                                                   Product.BANANA,
                                                   Product.MELON,
                                                   Product.LIME);
        shoppingBasket.addAll(productList);
        int totalPrice = shoppingBasket.getTotalPrice();

        Assert.assertEquals(120, totalPrice );
    }

    @Test
    public void testTotalPriceWhenNoDiscountsMultiple(){
        PriceList priceList = new DefaultPriceList();
        ShoppingBasket shoppingBasket = new ShoppingBasket(priceList);
        List<Product> productList = Arrays.asList( Product.APPLE,
                                                   Product.APPLE,
                                                   Product.BANANA,
                                                   Product.MELON,
                                                   Product.LIME);
        shoppingBasket.addAll(productList);
        int totalPrice = shoppingBasket.getTotalPrice();

        Assert.assertEquals(155, totalPrice );
    }

    @Test
    public void testTotalPriceWhenBuyOneGetOneFreeDiscountApplied(){
        PriceList priceList = new DefaultPriceList();
        ShoppingBasket shoppingBasket = new ShoppingBasket(priceList);
        List<Product> productList = Arrays.asList( Product.APPLE,
                                                   Product.BANANA,
                                                   Product.MELON,
                                                   Product.LIME,
                                                   Product.MELON );
        shoppingBasket.addAll(productList);
        int totalPrice = shoppingBasket.getTotalPrice();

        Assert.assertEquals(120, totalPrice );
    }

    @Test
    public void testTotalPriceWhenThreeForThePriceOfTwoDiscountApplied(){
        PriceList priceList = new DefaultPriceList();
        ShoppingBasket shoppingBasket = new ShoppingBasket(priceList);
        List<Product> productList = Arrays.asList( Product.APPLE,
                                                   Product.BANANA,
                                                   Product.MELON,
                                                   Product.LIME,
                                                   Product.LIME,
                                                   Product.LIME);
        shoppingBasket.addAll(productList);
        int totalPrice = shoppingBasket.getTotalPrice();

        Assert.assertEquals(135, totalPrice );
    }

    @Test
    public void  testBasketIsEmptyAfterCreation(){
        PriceList priceList = new DefaultPriceList();
        ShoppingBasket shoppingBasket = new ShoppingBasket(priceList);

        Assert.assertEquals(0, shoppingBasket.getProducts().size());
    }

    @Test
    public void  testProductIsInBasketAfterAddition(){
        PriceList priceList = new DefaultPriceList();
        ShoppingBasket shoppingBasket = new ShoppingBasket(priceList);

        shoppingBasket.add(Product.BANANA);
        Map<Product, Integer> products = shoppingBasket.getProducts();

        Assert.assertEquals(1, products.size() );
        Assert.assertEquals( 1, products.get(Product.BANANA).intValue());
    }

    @Test
    public void  testProductsAreInBasketAfterAddition(){
        PriceList priceList = new DefaultPriceList();
        ShoppingBasket shoppingBasket = new ShoppingBasket(priceList);

        List<Product> productList = Arrays.asList( Product.APPLE,
                Product.BANANA,
                Product.MELON,
                Product.LIME,
                Product.LIME,
                Product.LIME);
        shoppingBasket.addAll(productList);
        Map<Product, Integer> products = shoppingBasket.getProducts();

        Assert.assertEquals(4, products.size() );
        Assert.assertEquals( 1, products.get(Product.APPLE).intValue());
        Assert.assertEquals( 1, products.get(Product.BANANA).intValue());
        Assert.assertEquals( 1, products.get(Product.MELON).intValue());
        Assert.assertEquals( 3, products.get(Product.LIME).intValue());
    }
}
