package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Collection<House> houses;


    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        if (type.equals("ShortHouse")) {
            house = new ShortHouse(name);
        } else if (type.equals("LongHouse")) {
            house = new LongHouse(name);
        } else {
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        houses.add(house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        if (type.equals("Ball")) {
            toy = new Ball();
        } else if (type.equals("Mouse")) {
            toy = new Mouse();
        } else {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        House house = this.houses.stream().filter(h -> h.getName().equals(houseName))
                .findFirst().orElse(null);
        Toy toy = toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }
        assert house != null;
        house.buyToy(toy);
        toys.removeToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        if (catType.equals("ShorthairCat")) {
            cat = new ShorthairCat(catName, catBreed, price);
        } else if (catType.equals("LonghairCat")) {
            cat = new LonghairCat(catName, catBreed, price);
        } else {
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        House house = this.houses.stream().filter(h -> h.getName().equals(houseName))
                .findFirst().orElse(null);

        assert house != null;
        int before = house.getCats().size();
        house.addCat(cat);
        int after = house.getCats().size();

        if (after > before) {
            return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, cat.getClass().getSimpleName(), houseName);
        }
        return UNSUITABLE_HOUSE;
    }

    @Override
    public String feedingCat(String houseName) {
        House house = this.houses.stream().filter(h -> h.getName().equals(houseName))
                .findFirst().orElse(null);

        assert house != null;
        Collection<Cat> cats = house.getCats();
        for (Cat cat : cats) {
            cat.eating();
        }

        return String.format(FEEDING_CAT, cats.size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = this.houses.stream().filter(h -> h.getName().equals(houseName))
                .findFirst().orElse(null);
        assert house != null;
        double catPrices = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double toyPrices = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        double housePrices = catPrices + toyPrices;
        return String.format(VALUE_HOUSE, houseName, housePrices);
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        for (House house: houses) {
            builder.append(house.getStatistics());
        }
        return builder.toString().trim();
    }
}
