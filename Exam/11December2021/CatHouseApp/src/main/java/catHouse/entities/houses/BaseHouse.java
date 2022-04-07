package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.BaseToy;
import catHouse.entities.toys.Toy;

import java.util.Collection;

public abstract class BaseHouse implements House{
    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private  Collection<Cat> cats;

    protected BaseHouse(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
    }
    @Override
    public int sumSoftness() {
        return 0;
    }

    @Override
    public void addCat(Cat cat) {

    }

    @Override
    public void removeCat(Cat cat) {

    }

    @Override
    public void buyToy(Toy toy) {

    }

    @Override
    public void feeding() {

    }

    @Override
    public String getStatistics() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public Collection<Cat> getCats() {
        return null;
    }

    @Override
    public Collection<Toy> getToys() {
        return null;
    }
}
