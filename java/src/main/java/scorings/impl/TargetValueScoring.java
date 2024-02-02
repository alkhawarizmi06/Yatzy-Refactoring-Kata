package scorings.impl;

import java.util.Arrays;

import enums.ScoringStrategyEnum;
import models.DicesRoll;
import scorings.ScoringStrategy;
import utils.DicesRollValidatorUtil;

public class TargetValueScoring implements ScoringStrategy {

    protected int targetValue;

    public TargetValueScoring(int targetValue) {
        this.targetValue = targetValue;
    }

    public TargetValueScoring() {
        this.targetValue = 1;
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {
        validateDicesRoll(dicesRoll);

        return Arrays.stream(dicesRoll.getDices())
                .map(e -> e == this.targetValue ? e : 0)
                .sum();
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.ONES_SCORING_STRATEGY.getScoringStrategyName();
    }

    private void validateDicesRoll(DicesRoll dicesRoll) {
        DicesRollValidatorUtil.validateDicesRoll(dicesRoll);
    }
}
