package scorings.impl;

import models.DicesRoll;
import scorings.ScoringStrategy;
import utils.DicesCountUtil;
import utils.DicesRollValidatorUtil;

public class NumberOfPairsScoring implements ScoringStrategy {

    protected int numberOfPairsTarget;

    public NumberOfPairsScoring(int numberOfPairsTarget) {
        this.numberOfPairsTarget = numberOfPairsTarget;
    }

    public NumberOfPairsScoring() {
        this.numberOfPairsTarget = 1;
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {
        validateDicesRoll(dicesRoll);

        int[] dicesValueCount = DicesCountUtil.getDicesValueCount(dicesRoll);
        int numberOfPairs = 0;
        int currentScore = 0;

        for (int index = dicesValueCount.length - 1; index >= 0 && numberOfPairs < this.numberOfPairsTarget; index--) {
            if (dicesValueCount[index] >= 2) {
                numberOfPairs++;
                currentScore += (index + 1);
            }
        }

        return currentScore * 2;
    }

    @Override
    public String getScoringStrategyName() {
        return "DEFAULT";
    }

    private void validateDicesRoll(DicesRoll dicesRoll) {
        DicesRollValidatorUtil.validateDicesRoll(dicesRoll);
    }
}

