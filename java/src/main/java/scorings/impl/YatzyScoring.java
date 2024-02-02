package scorings.impl;

import enums.ScoringStrategyEnum;
import models.DicesRoll;
import scorings.ScoringStrategy;
import utils.DicesCountUtil;
import utils.DicesRollValidatorUtil;

public class YatzyScoring implements ScoringStrategy {

    private static final int YATZY_SCORE = 50;

    @Override
    public int computeScore(DicesRoll dicesRoll) {
        validateDicesRoll(dicesRoll);

        int[] elementsCount = DicesCountUtil.getElementsCount(dicesRoll);
        for (int count : elementsCount) {
            if (count == dicesRoll.getDices().length) {
                return YATZY_SCORE;
            }
        }
        return 0;
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.YATZY_SCORING_STRATEGY.getScoringStrategyName();
    }

    private void validateDicesRoll(DicesRoll dicesRoll) {
        DicesRollValidatorUtil.validateDicesRoll(dicesRoll);
    }
}

