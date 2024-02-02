package scoring.impl;

import constants.YatzyConstants;
import model.DicesRoll;
import scoring.GameScorer;
import util.GameUtil;
import validators.DicesRollValidator;
import validators.DicesRollValidatorImpl;

public class NOfKindScoring implements GameScorer {

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

        int[] elementsCount = GameUtil.getElementsCount(dicesRoll);
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
