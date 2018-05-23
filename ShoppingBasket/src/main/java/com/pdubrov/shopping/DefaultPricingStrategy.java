package com.pdubrov.shopping;

public class DefaultPricingStrategy implements PricingStrategy {

    /**
     * Returns total price of a product given quantity and unitPrice
     *
     * @param quantity
     * @param unitPrice
     * @return total price
     */
    @Override
    public int price(int quantity, int unitPrice) {
        if (quantity < 0 || unitPrice < 0) throw new IllegalArgumentException( "Quantity and unit price can not be negative");
        return quantity * unitPrice;
    }
}
