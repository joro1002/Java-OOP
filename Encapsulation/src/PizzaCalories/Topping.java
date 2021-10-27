package PizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String type, double weight) {
        this.setToppingType(type);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
            case "Veggies":
            case "Cheese":
            case "Sauce":
                this.toppingType = toppingType;
                break;
            default:
                String msg = String.format("Cannot place %s on top of your pizza.", toppingType);
                throw new IllegalArgumentException(msg);
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 50) {
            this.weight = weight;
        } else {
            String msg = String.format("%s weight should be in the range [1..50].", this.toppingType);
            throw new IllegalArgumentException(msg);
        }
    }

    public double calculateCalories() {
        double typeModifier = this.getToppingModifier(this.toppingType);
        return 2 * this.weight * typeModifier;
    }

    private double getToppingModifier(String type) {

        switch (type) {
            case "Meat":
                return 1.2;
            case "Veggies":
                return 0.8;
            case "Cheese":
                return 1.1;
            case "Sauce":
                return 0.9;
            default:
                return 0;
        }
    }
}
