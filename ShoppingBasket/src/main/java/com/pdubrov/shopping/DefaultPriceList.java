package com.pdubrov.shopping;

public class DefaultPriceList implements PriceList {

    /**
     * Returns pricing strategy (e.g. discounts) for given Product
     *
     * @param product
     * @return PricingStrategy
     */
    @Override
    public PricingStrategy getPricingStrategy(Product product) {
        PricingStrategy pricingStrategy;
        switch (product) {
            case APPLE:
                pricingStrategy = new DefaultPricingStrategy();
                break;
            case BANANA:
                pricingStrategy = new DefaultPricingStrategy();
                break;
            case MELON:
                pricingStrategy = new BuyXGetYFreePricingStrategy(1, 1);
                break;
            case LIME:
                pricingStrategy = new BuyXGetYFreePricingStrategy(2, 1);
                break;
            default:
                throw new IllegalArgumentException("Unknown Product: " + product);
        }
        return pricingStrategy;
    }

    /**
     * Returns unit price for given product
     *
     * @param product
     * @return unit price
     */
    @Override
    public int getUnitPrice(Product product) {
        int unitPrice;
        switch (product) {
            case APPLE:
                unitPrice = 35;
                break;
            case BANANA:
                unitPrice = 20;
                break;
            case MELON:
                unitPrice = 50;
                break;
            case LIME:
                unitPrice = 15;
                break;

            default:
                throw new IllegalArgumentException("Unknown Product: " + product);
        }
        return unitPrice;
    }
}
