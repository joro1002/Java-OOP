package christmasRaces.entities.races;

import christmasRaces.entities.drivers.Driver;

import java.util.Collection;

public class RaceImpl implements Race{
    private String name;
    private int laps;
    private Collection<Driver> drivers;

    public RaceImpl(String name, int laps){
        this.name = name;
        this.laps = laps;
    }
    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getLaps() {
        return 0;
    }

    @Override
    public Collection<Driver> getDrivers() {
        return null;
    }

    @Override
    public void addDriver(Driver driver) {

    }
}
