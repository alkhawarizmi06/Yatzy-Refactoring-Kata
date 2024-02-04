package scorings.impl;

import java.util.Arrays;

import enums.ScoringStrategyEnum;
import models.DicesRoll;
import scorings.ScoringStrategy;
import utils.DicesCountUtil;
import utils.DicesRollValidatorUtil;

public class FullHouseScoring implements ScoringStrategy {

    private static final int FULL_DEFAULT_SCORE = 0;
    private static final int FULL_SUM = 5;
    private static final int FULL_NUMBER = 2;

    @Override
    public int computeScore(DicesRoll dicesRoll) {

        DicesRollValidatorUtil.validateDicesRoll(dicesRoll);

        if (isFullHouse(dicesRoll)) {
            return Arrays.stream(dicesRoll.getDices()).sum();
        }

        return FULL_DEFAULT_SCORE;
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.FULL_HOUSE_SCORING_STRATEGY.getScoringStrategyName();
    }

    private boolean isFullHouse(DicesRoll dicesRoll) {
        int[] dicesValueCount = DicesCountUtil.getDicesValueCount(dicesRoll);
        int[] filteredDices = Arrays.stream(dicesValueCount).filter(dice -> dice != 0).toArray();
        return filteredDices.length == FULL_NUMBER && Arrays.stream(filteredDices).sum() == FULL_SUM;
    }
}
