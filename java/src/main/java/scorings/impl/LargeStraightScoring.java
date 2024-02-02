package scorings.impl;

import constants.YatzyConstants;
import enums.ScoringStrategyEnum;
import models.DicesRoll;
import scorings.ScoringStrategy;
import utils.DicesCountUtil;
import validators.DicesRollValidator;
import validators.DicesRollValidatorImpl;

public class LargeStraightScoring implements ScoringStrategy {

    private DicesRollValidator dicesRollValidator;

    public LargeStraightScoring () {
        this.dicesRollValidator = new DicesRollValidatorImpl();
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {

         if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException(YatzyConstants.INVALID_DICES_ROLL);
        }

        int[] elementsCount = DicesCountUtil.getElementsCount(dicesRoll);
        for (int index = 1; index < dicesRoll.getDices().length; index ++) {
            if ( elementsCount[index] != 1) {
                return 0;
            }
        }

        return 20;
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.LARGE_STRAIGHT_SCORING_STRATEGY.getScoringStrategyName();
    }

}
