package VehiclesExtension;

import Vehicles.Truck;
import Vehicles.Vehicle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carTokens = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]), Integer.parseInt(carTokens[3]));

        String[] truckTokens = scanner.nextLine().split("\\s+");

        Truck truck = new Truck(Double.parseDouble(carTokens[1]), Double.parseDouble(carTokens[2]));
        String[] busTokens = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(busTokens[1]), Double.parseDouble(busTokens[2]), Integer.parseInt(busTokens[3]));

        int count = Integer.parseInt(scanner.nextLine());

        while (count-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            if (tokens[0].equals("Drive") && tokens[1].equals("Bus")) {
                System.out.println();
            }
            if (tokens[0].contains("Drive")) {
                if (tokens[1].equals("Car")) {
                    System.out.println(car.drive(Double.parseDouble(tokens[2])));
                } else {
                    System.out.println(truck.drive(Double.parseDouble(tokens[2])));
                }
            } else if (tokens[0].equals("Refuel")) {
                if (tokens[1].equals("Car")) {
                    car.refuel(Double.parseDouble(tokens[2]));
                } else {
                    truck.refuel(Double.parseDouble(tokens[2]));
                }
            }
        }

        System.out.println(car);
        System.out.println(truck);
    }
}
