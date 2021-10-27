package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
    private static final double OXYGEN = 70;
    public Biologist(String name) {
        super(name, OXYGEN);
    }

    @Override
    public void breath() {
        this.setOxygen(this.getOxygen() - 5);
    }
}
