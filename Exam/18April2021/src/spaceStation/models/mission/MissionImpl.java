package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {

    @Override
    public void explore(Planet planet, List<Astronaut> astronauts) {
        for (int i = 0; i < astronauts.size(); i++) {
            Astronaut astronaut = astronauts.get(i);
            for (int item = 0; item < planet.getItems().size(); item++) {
                String currentItem = planet.getItems().get(item);
                astronaut.getBag().getItems().add(currentItem);
                planet.getItems().remove(currentItem);
                item--;
                astronaut.breath();

                if (!astronaut.canBreath()) {
                    astronauts.remove(astronaut);
                    i--;
                    break;
                }
            }

        }
    }
}
