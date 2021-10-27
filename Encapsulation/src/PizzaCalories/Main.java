package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String[] tokensPizza = sc.nextLine().split("\\s+");

            String name = tokensPizza[1];
            int countToppings = Integer.parseInt(tokensPizza[2]);
            Pizza pizza = new Pizza(name, countToppings);

            String[] tokensDough = sc.nextLine().split("\\s+");
            String flourType = tokensDough[1];
            String bakingTechnique = tokensDough[2];
            double weight = Double.parseDouble(tokensDough[3]);
            Dough dough = new Dough(flourType, bakingTechnique, weight);
            pizza.setDough(dough);

            String command = sc.nextLine();

            while (!command.equals("END")) {
                String[] tokens = command.split("\\s+");
                String type = tokens[1];
                double weightTopping = Double.parseDouble(tokens[2]);
                Topping topping = new Topping(type, weightTopping);

                pizza.addTopping(topping);


                command = sc.nextLine();
            }

            System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
        }catch (IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }
    }
}
