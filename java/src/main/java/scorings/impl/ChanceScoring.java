package scorings.impl;

import java.util.Arrays;

import enums.ScoringStrategyEnum;
import models.DicesRoll;
import scorings.ScoringStrategy;
import utils.DicesRollValidatorUtil;

public class ChanceScoring implements ScoringStrategy {

    @Override
    public int computeScore(DicesRoll dicesRoll) {
       
        DicesRollValidatorUtil.validateDicesRoll(dicesRoll);
    
        return Arrays.stream(dicesRoll.getDices()).sum();
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.CHANCE_SCORING_STRATEGY.getScoringStrategyName();
    }
    
}
