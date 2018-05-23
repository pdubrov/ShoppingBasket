package com.pdubrov.shopping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingBasket {

    private PriceList priceList;
    private Map<Product, Integer> products = new HashMap<>();

    /**
     * Constructs Shopping basket with price list in mind
     *
     * @param priceList
     */
    public ShoppingBasket(PriceList priceList) {
        this.priceList = priceList;
    }

    /**
     * Adds 1 unit of product to shopping basket
     *
     * @param product
     */
    public void add(Product product) {
        Integer quantity = products.getOrDefault(product, 0);
        products.put(product, quantity + 1);
    }

    /**
     * Adds list of products to shopping basket
     *
     * @param productList
     */
    public void addAll(List<Product> productList) {
        productList.forEach(this::add);
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    /**
     * Returns total price of all products in shopping basket
     *
     * @return
     */
    public int getTotalPrice() {
        int totalBasketPrice = 0;
        for ( Map.Entry<Product,Integer> entry : products.entrySet() )
        {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            PricingStrategy pricingStrategy = priceList.getPricingStrategy( product );
            int unitPrice = priceList.getUnitPrice(product);
            int totalPrice = pricingStrategy.price(quantity,unitPrice);
            totalBasketPrice += totalPrice;
        }
        return(totalBasketPrice);
    }
}
