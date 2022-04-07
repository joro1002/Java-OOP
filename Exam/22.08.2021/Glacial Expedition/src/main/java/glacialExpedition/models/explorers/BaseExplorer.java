package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

import glacialExpedition.common.ExceptionMessages;

public abstract class BaseExplorer implements Explorer{
    private String name;
    private double energy;
    private Suitcase suitcase;

    protected BaseExplorer(String name, double energy){
        this.setName(name);
        this.setEnergy(energy);
        this.suitcase = new Carton();
    }

    public void setEnergy(double energy) {
        if (energy < 0){
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    @Override
    public boolean canSearch() {
        return energy > 0;
    }

    @Override
    public Suitcase getSuitcase() {
        return this.suitcase;
    }

    @Override
    public void search() {
        setEnergy(energy - 15);
        if (energy < 0){
            setEnergy(0);
        }
    }
}
