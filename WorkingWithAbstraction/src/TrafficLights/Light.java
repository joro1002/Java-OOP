package TrafficLights;

import java.util.List;

public class Light {
    private Colors colors;

    public Light(Colors colors){
        this.colors = colors;
    }

    public void ChangeColor() {
        switch (this.colors) {
            case RED:
                this.colors = Colors.GREEN;
                break;
            case GREEN:
                this.colors = Colors.YELLOW;
                break;
            case YELLOW:
                this.colors = Colors.RED;
                break;
        }
    }

    public Colors getColors() {
        return colors;
    }
}
