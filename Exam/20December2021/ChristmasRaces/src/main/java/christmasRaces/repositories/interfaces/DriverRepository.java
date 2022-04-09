package christmasRaces.repositories.interfaces;

import christmasRaces.entities.drivers.Driver;

import java.util.Collection;

public class DriverRepository implements Repository<Driver>{
    private Collection<Driver> models;
    @Override
    public Driver getByName(String name) {
        return null;
    }

    @Override
    public Collection<Driver> getAll() {
        return null;
    }

    @Override
    public void add(Driver model) {

    }

    @Override
    public boolean remove(Driver model) {
        return false;
    }
}
