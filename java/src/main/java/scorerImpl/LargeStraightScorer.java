package scorerImpl;

import constants.ScoringStrategyEnum;
import constants.YatzyConstants;
import model.DicesRoll;
import scorer.GameScorer;
import util.GameUtil;
import validators.DicesRollValidator;
import validators.DicesRollValidatorImpl;

public class LargeStraightScorer implements GameScorer {

    private DicesRollValidator dicesRollValidator;

    public LargeStraightScorer () {
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
