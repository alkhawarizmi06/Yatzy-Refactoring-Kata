package scorings.impl;

import java.util.Arrays;

import constants.YatzyConstants;
import enums.ScoringStrategyEnum;
import models.DicesRoll;
import scorings.ScoringStrategy;
import utils.DicesCountUtil;
import validators.DicesRollValidator;
import validators.DicesRollValidatorImpl;

public class FullHouseScoring implements ScoringStrategy {

    private static final int FULL_DEFAULT_SCORE = 0;
    private static final int FULL_SUM = 5;
    private static final int FULL_NUMBER = 2;

    private DicesRollValidator dicesRollValidator;

    public FullHouseScoring () {
         this.dicesRollValidator = new DicesRollValidatorImpl();
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {

         if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException(YatzyConstants.INVALID_DICES_ROLL);
        }

        int[] elementsCount = DicesCountUtil.getElementsCount(dicesRoll);
        int[] result = Arrays.stream(elementsCount).filter(e -> e != 0).toArray();

        if (result.length == FULL_NUMBER && Arrays.stream(result).sum() == FULL_SUM) {
            return Arrays.stream(dicesRoll.getDices()).sum();
        }

        return FULL_DEFAULT_SCORE;
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.FULL_HOUSE_SCORING_STRATEGY.getScoringStrategyName();
    }

}
