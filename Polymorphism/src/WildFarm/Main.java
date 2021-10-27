package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!command.equals("End")) {
            String[] animalTokens = command.split("\\s+");
            String[] foodTokens = scanner.nextLine().split("\\s+");
            Animal animal = null;
            Food food;

            switch (foodTokens[0]) {
                case "Vegetable":
                    food = new Vegetable(Integer.parseInt(foodTokens[1]));
                    break;
                case "Meat":
                    food = new Meat(Integer.parseInt(foodTokens[1]));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + foodTokens[0]);
            }

            switch (animalTokens[0]) {
                case "Cat":
                    try {
                        animal = new Cat(animalTokens[0], animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3], animalTokens[4]);
                        animal.makeSound();
                        animal.eat(food);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    animals.add(animal);
                    break;
                case "Tiger":
                    try {
                        animal = new Tiger(animalTokens[0], animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3]);
                        animal.makeSound();
                        animal.eat(food);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                     animals.add(animal);
                    break;
                case "Zebra":
                    try {
                        animal = new Zebra(animalTokens[0], animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3]);
                        animal.makeSound();
                        animal.eat(food);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    animals.add(animal);
                    break;
                case "Mouse":
                    try {
                        animal = new Mouse(animalTokens[0], animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3]);
                        animal.makeSound();
                        animal.eat(food);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                     animals.add(animal);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + animalTokens[0]);
            }

            command = scanner.nextLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }

    }
}
