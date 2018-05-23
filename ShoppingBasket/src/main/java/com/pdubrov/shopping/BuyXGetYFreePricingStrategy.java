package com.pdubrov.shopping;

public class BuyXGetYFreePricingStrategy implements PricingStrategy {
    private int quantityToBuy;
    private int quantityToGetForFree;

    /**
     * Creates BuyXGetYFreePricingStrategy given initial parameters
     *
     * @param quantityToBuy
     * @param quantityToGetForFree
     */
    public BuyXGetYFreePricingStrategy(int quantityToBuy, int quantityToGetForFree) {
        if (quantityToBuy < 0 || quantityToGetForFree < 0)
            throw new IllegalArgumentException( "quantityToBuy and quantityToGetForFree can not be negative");
        this.quantityToBuy = quantityToBuy;
        this.quantityToGetForFree = quantityToGetForFree;
    }

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
        int lotSize = quantityToBuy + quantityToGetForFree;
        int lotPrice = quantityToBuy * unitPrice;
        int numberOfLots = quantity / lotSize;
        int remainingQuantity = quantity % lotSize;
        return numberOfLots * lotPrice + remainingQuantity * unitPrice;
    }
}
