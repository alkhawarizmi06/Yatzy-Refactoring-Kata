package engine;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import constants.YatzyConstants;
import model.DicesRoll;
import scoring.GameScorer;

public class YatzyScoringEngineImpl implements YatzyScoringEngine {

    private Set<Object> socoringStrategies;

    public YatzyScoringEngineImpl() {
        this.socoringStrategies = YatzyScoringStrategyLoader.loadScoringStrategies("scoring.impl");
    }

    public int computeScore(String scoringStrategyName, DicesRoll dicesRoll) {
        List<Object> currentScoringStrategies = this.socoringStrategies.stream()
                .filter(scoringStrategy -> scoringStrategy != null
                        && ((GameScorer) scoringStrategy).getScoringStrategyName().equals(scoringStrategyName))
                .collect(Collectors.toList());
        if (currentScoringStrategies.size() == 0) {
            throw new IllegalArgumentException(YatzyConstants.UNKNOWN_SCORING_STRATEGY);
        }
        GameScorer scoringStrategy = (GameScorer) currentScoringStrategies.get(0);
        return scoringStrategy.computeScore(dicesRoll);
    }

    @Override
    public int getScoringStrategiesCount() {
        return this.socoringStrategies.size();
    }

}
