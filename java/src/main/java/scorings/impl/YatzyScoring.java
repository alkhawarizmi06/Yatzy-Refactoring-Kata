package scorings.impl;

import constants.YatzyConstants;
import enums.ScoringStrategyEnum;
import models.DicesRoll;
import scorings.ScoringStrategy;
import utils.DicesCountUtil;
import validators.DicesRollValidator;
import validators.DicesRollValidatorImpl;

public class YatzyScoring implements ScoringStrategy {

    private DicesRollValidator dicesRollValidator;

    public YatzyScoring() {
        this.dicesRollValidator = new DicesRollValidatorImpl();
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException(YatzyConstants.INVALID_DICES_ROLL);
        }

        int[] elementsCount = DicesCountUtil.getElementsCount(dicesRoll);
        for (int index = 0; index < dicesRoll.getDiceFacets(); index++)
            if (elementsCount[index] == 5)
                return 50;
        return 0;
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.YATZY_SCORING_STRATEGY.getScoringStrategyName();
    }

}
