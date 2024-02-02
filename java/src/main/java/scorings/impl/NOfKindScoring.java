package scorings.impl;

import constants.YatzyConstants;
import models.DicesRoll;
import scorings.ScoringStrategy;
import utils.DicesCountUtil;
import validators.DicesRollValidator;
import validators.DicesRollValidatorImpl;

public class NOfKindScoring implements ScoringStrategy {

    private DicesRollValidator dicesRollValidator;
    protected int targetValue;

    public NOfKindScoring() {
        this.dicesRollValidator = new DicesRollValidatorImpl();
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {

         if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException(YatzyConstants.INVALID_DICES_ROLL);
        }

        int[] elementsCount = DicesCountUtil.getElementsCount(dicesRoll);
        for (int index = 0; index < dicesRoll.getDiceFacets(); index++)
            if (elementsCount[index] >= this.targetValue)
                return (index + 1) * this.targetValue;
        return 0;
    }

    @Override
    public String getScoringStrategyName() {
        return "DEFAULT";
    }

}
