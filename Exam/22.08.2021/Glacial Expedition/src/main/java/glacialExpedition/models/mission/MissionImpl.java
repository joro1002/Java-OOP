package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MissionImpl implements Mission{
    @Override
    public void explore(State state, List<Explorer> explorers) {
        List<Explorer> overZeroEnergy = explorers.stream().filter(e -> e.getEnergy() > 0).collect(Collectors.toList());

        for (int i = 0; i < overZeroEnergy.size(); i++) {
            Explorer explorer = overZeroEnergy.get(i);
            for (int item = 0; item < state.getExhibits().size(); item++) {
                String currentItem = state.getExhibits().get(item);
                explorer.getSuitcase().getExhibits().add(currentItem);
                state.getExhibits().remove(currentItem);
                item--;
                explorer.search();
                if (!explorer.canSearch()){
                    explorers.remove(explorer);
                    i--;
                    break;
                }
            }
        }
    }
}
