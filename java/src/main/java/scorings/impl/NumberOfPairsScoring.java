package scorings.impl;

import constants.YatzyConstants;
import models.DicesRoll;
import scorings.GameScorer;
import utils.GameUtil;
import validators.DicesRollValidator;
import validators.DicesRollValidatorImpl;

public class NumberOfPairsScoring implements GameScorer {

    protected int numberOfPairsTarget;
    private DicesRollValidator dicesRollValidator;

    public NumberOfPairsScoring () {
         this.dicesRollValidator = new DicesRollValidatorImpl();
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
        return "DEFAULT";
    }

}
