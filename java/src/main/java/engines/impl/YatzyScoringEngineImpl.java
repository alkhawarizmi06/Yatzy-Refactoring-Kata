package engines.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import constants.YatzyConstants;
import engines.YatzyScoringEngine;
import exceptions.ScoringStrategyLoadingException;
import exceptions.UnknownScoringStrategyException;
import models.DicesRoll;
import scorings.ScoringStrategy;
import utils.YatzyScoringStrategyLoaderUtil;

public class YatzyScoringEngineImpl implements YatzyScoringEngine {

    private Set<ScoringStrategy> socoringStrategies;

    public YatzyScoringEngineImpl() {
        try {
        this.socoringStrategies = YatzyScoringStrategyLoaderUtil.loadScoringStrategies("scorings.impl");
        } catch (ScoringStrategyLoadingException exception) {
            // we should use a real logger for a real entreprise project
            System.out.println("Failed to load scoring strategy classes");
            this.socoringStrategies = Collections.emptySet();
        }
    }

    public int computeScore(String scoringStrategyName, DicesRoll dicesRoll) throws UnknownScoringStrategyException {

        List<ScoringStrategy> currentScoringStrategies = this.socoringStrategies.stream()
                .filter(scoringStrategy -> scoringStrategy != null
                        && scoringStrategy.getScoringStrategyName().equals(scoringStrategyName))
                .collect(Collectors.toList());
        if (currentScoringStrategies.isEmpty()) {
            throw new UnknownScoringStrategyException(YatzyConstants.UNKNOWN_SCORING_STRATEGY);
        }
        ScoringStrategy scoringStrategy = currentScoringStrategies.get(0);
        return scoringStrategy.computeScore(dicesRoll);
        
    }

    @Override
    public int getScoringStrategiesCount() {
        return this.socoringStrategies.size();
    }

}
