package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private ExplorerRepository explorerRepository;
    private StateRepository stateRepository;

    int exploredStatesCount = 0;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        if (type.equals("NaturalExplorer")) {
            explorer = new NaturalExplorer(explorerName);
        } else if (type.equals("GlacierExplorer")) {
            explorer = new GlacierExplorer(explorerName);
        } else if (type.equals("AnimalExplorer")) {
            explorer = new AnimalExplorer(explorerName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        this.explorerRepository.add(explorer);
        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        state.getExhibits().addAll(Arrays.asList(exhibits));
        stateRepository.add(state);

        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        if (this.explorerRepository.getCollection().stream().noneMatch(e -> e.getName().equals(explorerName))) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        Explorer explorer = this.explorerRepository.byName(explorerName);
        this.explorerRepository.remove(explorer);

        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {
        List<Explorer> explorersForMission = this.explorerRepository.getCollection().stream().filter(e -> e.getEnergy() > 50).collect(Collectors.toList());

        if (explorersForMission.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        int countBefore = explorersForMission.size();
        Mission mission = new MissionImpl();
        State state = stateRepository.byName(stateName);
        mission.explore(state, explorersForMission);
        exploredStatesCount++;
        int countAfter = explorersForMission.size();

        return String.format(ConstantMessages.STATE_EXPLORER, stateName, countBefore - countAfter);
    }

    @Override
    public String finalResult() {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, exploredStatesCount)).append(System.lineSeparator());
        builder.append(ConstantMessages.FINAL_EXPLORER_INFO).append(System.lineSeparator());

        this.explorerRepository.getCollection().forEach(e -> {
            builder.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, e.getName())).append(System.lineSeparator());
            builder.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, e.getEnergy())).append(System.lineSeparator());

            List<String> exhibits = e.getSuitcase().getExhibits();
            if (exhibits.size() == 0) {
                builder.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, "None")).append(System.lineSeparator());
            } else {
                builder.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, String.join(", ", exhibits))).append(System.lineSeparator());
            }
        });

        return builder.toString().trim();
    }
}
