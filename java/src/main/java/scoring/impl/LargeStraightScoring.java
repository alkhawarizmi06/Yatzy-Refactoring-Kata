package scoring.impl;

import constants.YatzyConstants;
import enums.ScoringStrategyEnum;
import model.DicesRoll;
import scoring.GameScorer;
import util.GameUtil;
import validators.DicesRollValidator;
import validators.DicesRollValidatorImpl;

public class LargeStraightScoring implements GameScorer {

    private DicesRollValidator dicesRollValidator;

    public LargeStraightScoring () {
        this.dicesRollValidator = new DicesRollValidatorImpl();
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {

         if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException(YatzyConstants.INVALID_DICES_ROLL);
        }

        int[] elementsCount = GameUtil.getElementsCount(dicesRoll);
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
