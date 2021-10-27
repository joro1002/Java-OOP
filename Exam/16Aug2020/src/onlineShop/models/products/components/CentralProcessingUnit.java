package onlineShop.models.products.components;

import onlineShop.models.products.BaseProduct;

public class CentralProcessingUnit extends BaseComponent {
    public static final double MULTIPLIER_IS = 1.25;
    public CentralProcessingUnit(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance * MULTIPLIER_IS, generation);
    }
}
