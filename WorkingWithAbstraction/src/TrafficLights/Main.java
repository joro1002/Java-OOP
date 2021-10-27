package TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int count = Integer.parseInt(scanner.nextLine());

        List<Light> list = new ArrayList<>();

        for (String color: input) {
            Light light = new Light(Colors.valueOf(color));
            list.add(light);
        }

        for (int i = 0; i < count; i++) {
            for (Light light : list) {
                light.ChangeColor();
                System.out.print(light.getColors() + " ");
            }
            System.out.println();
        }
    }
}
