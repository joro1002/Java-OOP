package ClassBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());

        try {
            Box box = new Box(length, width, height);
            double surfaceArea = box.calculateSurfaceArea();
            System.out.printf("Surface Area - %.2f%n", surfaceArea);

            double lateralSurfaceArea = box.calculateLateralSurfaceArea();
            System.out.printf("Lateral Surface Area - %.2f%n", lateralSurfaceArea);

            double volume = box.calculateVolume();
            System.out.printf("Volume – %.2f", volume);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
