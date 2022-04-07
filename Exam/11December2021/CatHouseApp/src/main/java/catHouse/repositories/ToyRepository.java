package catHouse.repositories;

import catHouse.entities.houses.House;
import catHouse.entities.toys.Toy;

import java.util.Collection;

public class ToyRepository implements Repository {
    private Collection<Toy> toys;
    public ToyRepository(){

    }
    @Override
    public void buyToy(Toy toy) {

    }

    @Override
    public boolean removeToy(Toy toy) {
        return false;
    }

    @Override
    public Toy findFirst(String type) {
        return null;
    }
}
