package WildFarm;

import java.text.DecimalFormat;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private double animalWeight;
    private String livingRegion;
    private int foodEaten;

    protected Animal(String animalName, String animalType, double animalWeight, String livingRegion) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.livingRegion = livingRegion;
        this.foodEaten = 0;
    }

    protected abstract void makeSound();

    public void eat(Food food){
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString(){
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]", this.animalName, this.animalType,
                decimalFormat.format(this.animalWeight), this.livingRegion, this.foodEaten);
    }
}
