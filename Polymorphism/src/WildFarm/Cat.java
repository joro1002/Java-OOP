package WildFarm;

public class Cat extends Felime{
    private String breed;
    public Cat(String animalName, String animalType, double animalWeight, String livingRegion,String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food){
        super.eat(food);
    }

    @Override
    public String toString(){
        StringBuilder base = new StringBuilder(super.toString());

        base.insert(base.indexOf(",") + 2, this.breed + ", ");
        return base.toString();
    }
}
