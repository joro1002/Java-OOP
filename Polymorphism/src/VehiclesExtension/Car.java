package VehiclesExtension;

import java.text.DecimalFormat;

public class Car extends Vehicle{
    private static final double SUMMER_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, int capacity) {
        super(fuelQuantity, fuelConsumption + SUMMER_CONSUMPTION, capacity);
    }

    @Override
    public String drive(double distance){
        return "Car" + super.drive(distance);
    }

    @Override
    public String toString(){
        return "Car" + super.toString();
    }

}
