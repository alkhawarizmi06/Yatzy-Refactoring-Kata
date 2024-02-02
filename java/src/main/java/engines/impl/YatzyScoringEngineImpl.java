package engines.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import constants.YatzyConstants;
import engines.YatzyScoringEngine;
import models.DicesRoll;
import scorings.GameScorer;
import utils.YatzyScoringStrategyLoaderUtil;

public class YatzyScoringEngineImpl implements YatzyScoringEngine {

    private Set<GameScorer> socoringStrategies;

    public YatzyScoringEngineImpl() {
        this.socoringStrategies = YatzyScoringStrategyLoaderUtil.loadScoringStrategies("scorings.impl");
    }

    public int computeScore(String scoringStrategyName, DicesRoll dicesRoll) {
        List<GameScorer> currentScoringStrategies = this.socoringStrategies.stream()
                .filter(scoringStrategy -> scoringStrategy != null
                        && scoringStrategy.getScoringStrategyName().equals(scoringStrategyName))
                .collect(Collectors.toList());
        if (currentScoringStrategies.size() == 0) {
            throw new IllegalArgumentException(YatzyConstants.UNKNOWN_SCORING_STRATEGY);
        }
        GameScorer scoringStrategy = currentScoringStrategies.get(0);
        return scoringStrategy.computeScore(dicesRoll);
    }

    @Override
    public int getScoringStrategiesCount() {
        return this.socoringStrategies.size();
    }

}
