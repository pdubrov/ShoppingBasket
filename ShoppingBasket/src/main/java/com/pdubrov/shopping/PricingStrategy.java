package com.pdubrov.shopping;

public interface PricingStrategy {

    /**
     * Returns total price of a product given quantity and unitPrice
     *
     * @param quantity
     * @param unitPrice
     * @return total price
     */
    int price( int quantity, int unitPrice);

}
