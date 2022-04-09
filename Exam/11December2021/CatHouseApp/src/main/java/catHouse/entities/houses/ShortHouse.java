package catHouse.entities.houses;

import catHouse.entities.cat.Cat;

public class ShortHouse extends BaseHouse{
    public ShortHouse(String name) {
        super(name, 15);
    }

    @Override
    public void addCat(Cat cat) {
        if (getClass().getSimpleName().equals("LongHouse") && cat.getClass().getSimpleName().equals("LonghairCat")) {
            super.addCat(cat);
        } else if (getClass().getSimpleName().equals("ShortHouse") && cat.getClass().getSimpleName().equals("ShorthairCat")) {
            super.addCat(cat);

        }
    }
}
