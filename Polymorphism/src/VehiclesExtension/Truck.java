package VehiclesExtension;

import java.text.DecimalFormat;

public class Truck extends Vehicle{
    private static final double SUMMER_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, int capacity) {
        super(fuelQuantity, fuelConsumption + SUMMER_CONSUMPTION, capacity);
    }


    @Override
    public String drive(double distance){
        return "Truck" + super.drive(distance);
    }

    @Override
    public void refuel(double quantity) {
        super.refuel(quantity * 0.95);
    }

    @Override
    public String toString() {
        return "Truck" + super.toString();
    }
}
