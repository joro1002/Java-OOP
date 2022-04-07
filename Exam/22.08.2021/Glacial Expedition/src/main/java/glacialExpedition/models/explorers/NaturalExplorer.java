package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{
    public NaturalExplorer(String name) {
        super(name, 60);
    }

    @Override
    public void search() {
        setEnergy(getEnergy() - 7);
;    }
}
