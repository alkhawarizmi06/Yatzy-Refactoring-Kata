package scorings.impl;

import java.util.Arrays;

import enums.ScoringStrategyEnum;
import models.DicesRoll;
import scorings.ScoringStrategy;
import utils.DicesRollValidatorUtil;

public class YatzyScoring implements ScoringStrategy {

    private static final int YATZY_SCORE = 50;

    @Override
    public int computeScore(DicesRoll dicesRoll) {
        validateDicesRoll(dicesRoll);
        if (this.isYatzy(dicesRoll)) {
            return YATZY_SCORE;
        }

        return 0;
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.YATZY_SCORING_STRATEGY.getScoringStrategyName();
    }

    private boolean isYatzy(DicesRoll dicesRoll) {
        int firstDie = dicesRoll.getDices()[0];
        return Arrays.stream(dicesRoll.getDices()).allMatch(value -> value == firstDie);
    }

    private void validateDicesRoll(DicesRoll dicesRoll) {
        DicesRollValidatorUtil.validateDicesRoll(dicesRoll);
    }
}
