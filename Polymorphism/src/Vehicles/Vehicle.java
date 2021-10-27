package Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private DecimalFormat formatter;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.formatter = new DecimalFormat("##.##");
    }

    public String drive(double distance) {
        double fuelNeeded = distance * this.fuelConsumption;
        if (fuelNeeded > this.fuelQuantity) {
            return " needs refueling";
        }
        this.fuelQuantity-=fuelNeeded;
        return " travelled " + formatter.format(distance) +  " km";
    }

    public void refuel(double quantity) {
        this.fuelQuantity += quantity;
    }

    @Override
    public String toString(){
        return String.format(": %.2f", this.fuelQuantity);
    }
}
