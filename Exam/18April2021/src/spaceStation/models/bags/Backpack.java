package spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Backpack implements Bag {
    List<String> items;

    public Backpack() {
        items = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }
}
