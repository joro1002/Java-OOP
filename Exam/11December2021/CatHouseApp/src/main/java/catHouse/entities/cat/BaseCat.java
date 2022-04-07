package catHouse.entities.cat;

import catHouse.entities.toys.BaseToy;

public abstract class BaseCat implements Cat{

    private String name;
    private String breed;
    private int kilograms;
    private double price;

    protected BaseCat(String name, String breed, double price){
        this.name = name;
        this.breed = breed;
        this.price = price;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public int getKilograms() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public void eating() {

    }
}
