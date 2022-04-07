package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.BaseToy;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;

import static catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House{
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private  Collection<Cat> cats;

    protected BaseHouse(String name, int capacity){
        this.setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }
    @Override
    public int sumSoftness() {
        return toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (this.capacity > cats.size()){
            this.cats.add(cat);
        }else {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        for (Cat cat:
             cats) {
            cat.eating();
        }
    }

    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.name).append(" ").append(this.getClass().getSimpleName()).append(":").append(System.lineSeparator());

        builder.append("Cats: ");
        if (this.cats.isEmpty()) {
            builder.append("none");
        } else {
            for (Cat cat : cats) {
                builder.append(cat.getName()).append(" ");
            }
        }
        builder.append(System.lineSeparator());
        builder.append("Toys: ").append(this.toys.size()).append(" Softness: ").append(this.sumSoftness());
        builder.append(System.lineSeparator());

        return builder.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return this.cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return this.toys;
    }
}
