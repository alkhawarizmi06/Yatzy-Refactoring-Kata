package scorings.impl;

import java.util.Arrays;

import constants.YatzyConstants;
import enums.ScoringStrategyEnum;
import models.DicesRoll;
import scorings.GameScorer;
import validators.DicesRollValidator;
import validators.DicesRollValidatorImpl;

public class TargetValueScoring implements GameScorer {

    protected int targetValue;
    private DicesRollValidator dicesRollValidator;

    public TargetValueScoring () {
        this.dicesRollValidator = new DicesRollValidatorImpl();
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {

         if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException(YatzyConstants.INVALID_DICES_ROLL);
        }
        
        return Arrays.stream(dicesRoll.getDices()).map(e -> e == this.targetValue ? e : 0).sum();
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.ONES_SCORING_STRATEGY.getScoringStrategyName();
    }
  
} 
