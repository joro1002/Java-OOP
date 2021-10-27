package bakery.repositories.interfaces;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.bakedFoods.interfaces.BaseFood;

import java.util.ArrayList;
import java.util.Collection;

public class FoodRepositoryImpl implements FoodRepository<BakedFood> {
    private Collection<BakedFood> models;

    public FoodRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public BakedFood getByName(String name) {
        return this.models.stream()
                .filter(b -> b.getName().equals(name))
                .findFirst().orElse(null);
    }

    @Override
    public Collection<BakedFood> getAll() {
        return this.models;
    }

    @Override
    public void add(BakedFood bakedFood) {
        models.add(bakedFood);
    }
}
