package scorings.impl;

import java.util.Arrays;

import constants.YatzyConstants;
import enums.ScoringStrategyEnum;
import models.DicesRoll;
import scorings.ScoringStrategy;
import validators.DicesRollValidator;
import validators.DicesRollValidatorImpl;

public class ChanceScoring implements ScoringStrategy {

    private DicesRollValidator dicesRollValidator;

    public ChanceScoring () {
         this.dicesRollValidator = new DicesRollValidatorImpl();
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {
       
        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException(YatzyConstants.INVALID_DICES_ROLL);
        }
    
        return Arrays.stream(dicesRoll.getDices()).sum();
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.CHANCE_SCORING_STRATEGY.getScoringStrategyName();
    }
    
}
