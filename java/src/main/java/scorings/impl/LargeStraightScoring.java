package scorings.impl;

import enums.ScoringStrategyEnum;
import models.DicesRoll;
import scorings.ScoringStrategy;
import utils.DicesCountUtil;
import utils.DicesRollValidatorUtil;

public class LargeStraightScoring implements ScoringStrategy {

    private static final int LARGE_STRAIGHT_SCORE = 20;

    @Override
    public int computeScore(DicesRoll dicesRoll) {
        validateDicesRoll(dicesRoll);

        int[] dicesValueCount = DicesCountUtil.getDicesValueCount(dicesRoll);
        if (isLargeStraight(dicesValueCount, dicesRoll.getDices().length)) {
            return LARGE_STRAIGHT_SCORE;
        }

        return 0;
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.LARGE_STRAIGHT_SCORING_STRATEGY.getScoringStrategyName();
    }

    private void validateDicesRoll(DicesRoll dicesRoll) {
        DicesRollValidatorUtil.validateDicesRoll(dicesRoll);
    }

    private boolean isLargeStraight(int[] dicesValueCount, int dices) {
        for (int index = 1; index < dices; index++) {
            if (dicesValueCount[index] != 1) {
                return false;
            }
        }
        return true;
    }
}
