package com.pdubrov.shopping;

public interface PriceList {

    /**
     * Returns pricing strategy (e.g. discounts) for given Product
     *
     * @param product
     * @return PricingStrategy
     */
    PricingStrategy getPricingStrategy(Product product);

    /**
     * Returns unit price for given product
     *
     * @param product
     * @return unit price
     */
    int getUnitPrice(Product product);
}
