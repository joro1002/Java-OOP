package bakery.core;

import bakery.common.ExceptionMessages;
import bakery.common.OutputMessages;
import bakery.core.interfaces.Controller;
import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.bakedFoods.interfaces.Bread;
import bakery.entities.bakedFoods.interfaces.Cake;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.drinks.interfaces.Tea;
import bakery.entities.drinks.interfaces.Water;
import bakery.entities.tables.interfaces.InsideTable;
import bakery.entities.tables.interfaces.OutsideTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.*;

import java.awt.event.ItemListener;

public class ControllerImpl implements Controller {
    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;
    private double totalIncome;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository, DrinkRepository<Drink> drinkRepository, TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
        totalIncome = 0;
    }


    @Override
    public String addFood(String type, String name, double price) {
        BakedFood food = null;
        if ("Bread".equals(type)) {
            food = new Bread(name, price);
        } else if ("Cake".equals(type)) {
            food = new Cake(name, price);
        }else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }

        this.foodRepository.add(food);
        return String.format(OutputMessages.FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {
        Drink drink = null;

        if ("Tea".equals(type)) {
            drink = new Tea(name, portion, brand);
        } else if ("Water".equals(type)) {
            drink = new Water(name, portion, brand);
        }else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.FOOD_OR_DRINK_EXIST, type, name));
        }

        this.drinkRepository.add(drink);
        return String.format(OutputMessages.DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {
        Table table = null;

        if ("InsideTable".equals(type)) {
            table = new InsideTable(tableNumber, capacity);
        } else if ("OutsideTable".equals(type)) {
            table = new OutsideTable(tableNumber, capacity);
        }else {
            throw new IllegalArgumentException(String.format(ExceptionMessages.TABLE_EXIST, tableNumber));
        }

        this.tableRepository.add(table);

        return String.format(OutputMessages.TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {
        Table table = this.tableRepository.getAll().stream()
                .filter(t -> !t.isReserved() && t.getCapacity() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        if (table == null) {
            return String.format(OutputMessages.RESERVATION_NOT_POSSIBLE, numberOfPeople);
        } else {
            table.reserve(numberOfPeople);
        }
        return String.format(OutputMessages.TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        Table table = this.tableRepository.getByNumber(tableNumber);

        if (table == null || !table.isReserved()) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }

        BakedFood food = this.foodRepository.getByName(foodName);

        if (food == null) {
            return String.format(OutputMessages.NONE_EXISTENT_FOOD, foodName);
        }

        table.orderFood(food);

        return String.format(OutputMessages.FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        Table currentTable = this.tableRepository.getByNumber(tableNumber);

        if (currentTable == null || !currentTable.isReserved()) {
            return String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber);
        }

        Drink drinkOrdered = this.drinkRepository.getByNameAndBrand(drinkName, drinkBrand);

        if (drinkOrdered == null) {
            return String.format(OutputMessages.NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }

        currentTable.orderDrink(drinkOrdered);

        return String.format(OutputMessages.DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);

    }

    @Override
    public String leaveTable(int tableNumber) {
        Table currentTable= tableRepository.getByNumber(tableNumber);
        if (currentTable == null) {
            throw new IllegalArgumentException(String.format(OutputMessages.WRONG_TABLE_NUMBER, tableNumber));
        }
        double bill = currentTable.getBill();
        totalIncome += bill;
        currentTable.clear();

        return String.format(OutputMessages.BILL, tableNumber, bill);

    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder builder = new StringBuilder();

        this.tableRepository.getAll().forEach(currentTable -> {
            if (!currentTable.isReserved()) {
                builder.append(currentTable.getFreeTableInfo()).append(System.lineSeparator());
            }
        });

        return builder.toString().trim();
    }

    @Override
    public String getTotalIncome() {
        return String.format(OutputMessages.TOTAL_INCOME, totalIncome);
    }
}
