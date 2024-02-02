package scorerImpl;

import constants.ScoringStrategyEnum;
import constants.YatzyConstants;
import model.DicesRoll;
import scorer.GameScorer;
import util.GameUtil;
import validators.DicesRollValidator;

public class NumberOfPairsScorer implements GameScorer {

    private int numberOfPairsTarget = 1;
    private DicesRollValidator dicesRollValidator;

    public NumberOfPairsScorer (DicesRollValidator dicesRollValidator) {
        this.dicesRollValidator = dicesRollValidator;
    }

    public NumberOfPairsScorer(DicesRollValidator dicesRollValidator, int numberOfPairsTarget) {
        this.numberOfPairsTarget = numberOfPairsTarget;
        this.dicesRollValidator = dicesRollValidator;
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {

         if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException(YatzyConstants.INVALID_DICES_ROLL);
        }

        int[] elementsCount = GameUtil.getElementsCount(dicesRoll);
        int numberOfPairs = 0;
        int currentScore = 0;
        for (int index = elementsCount.length - 1; index >= 0; index--) {
            if (elementsCount[index] >= 2 && numberOfPairs < this.numberOfPairsTarget) {
                numberOfPairs++;
                currentScore += index + 1;
            }
        }

        return currentScore * 2;
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.SINGLE_PAIR_SCORING_STRATEGY.getScoringStrategyName();
    }

}
