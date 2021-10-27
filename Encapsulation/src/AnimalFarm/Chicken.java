package AnimalFarm;

public class Chicken {
    //fields
    private String name;
    private int age;

    //constructor
    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    //setters
    private void setName(String name) {
        //invalid -> name.lenght() <1
        if (name.length() < 1) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        //valid -> [0;15]
        //invalid -> < 0 or > 15
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private double calculateProductPerDay() {
        //до 6 год -> 2
        //до 12  -> 1
        //над 12 -> 0.75
        if (this.age < 6) {
            return 2;
        } else if (this.age < 12) {
            return 1;
        } else {
            return 0.75;
        }
    }

    public double productPerDay() {
        return this.calculateProductPerDay();
    }

    @Override
    public String toString() {
        //Chicken Chichi (age 10) can produce 1.00 eggs per day.
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.",
                this.name, this.age, this.productPerDay());
    }
}
