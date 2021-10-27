package animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        List<Animal> animals = new ArrayList<>();

        while (!command.equals("Beast!")) {
                String[] tokens = scanner.nextLine().split("\\s+");
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String gender = tokens[2];
                Animal animal = null;
                try {

                    switch (command) {
                        case "Dog":
                            animal = new Dog(name, age, gender);
                            break;
                        case "Frog":
                            animal = new Frog(name, age, gender);
                            break;
                        case "Cat":
                            animal = new Cat(name, age, gender);
                            break;
                        case "Kitten":
                            animal = new Kitten(name, age);
                            break;
                        case "Tomcat":
                            animal = new Tomcat(name, age);
                            break;
                    }
                }catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
                animals.add(animal);

                command = scanner.nextLine();

                animals.forEach(System.out::println);

        }
    }
}
