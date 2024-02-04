package scorings.impl;

import enums.ScoringStrategyEnum;
import models.DicesRoll;
import scorings.ScoringStrategy;
import utils.DicesCountUtil;
import utils.DicesRollValidatorUtil;

public class SmallStraightScoring implements ScoringStrategy {

    private static final int SMALL_STRAIGHT_SCORE = 15;

    @Override
    public int computeScore(DicesRoll dicesRoll) {
        validateDicesRoll(dicesRoll);

        int[] dicesValueCount = DicesCountUtil.getDicesValueCount(dicesRoll);
        if (isSmallStraight(dicesValueCount, dicesRoll.getDices().length)) {
            return SMALL_STRAIGHT_SCORE;
        }

        return 0;
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.SMALL_STRAIGHT_SCORING_STRATEGY.getScoringStrategyName();
    }

    private void validateDicesRoll(DicesRoll dicesRoll) {
        DicesRollValidatorUtil.validateDicesRoll(dicesRoll);
    }

    private boolean isSmallStraight(int[] dicesValueCount, int dices) {
        for (int index = 0; index < dices; index++) {
            if (dicesValueCount[index] != 1) {
                return false;
            }
        }
        return true;
    }
}

