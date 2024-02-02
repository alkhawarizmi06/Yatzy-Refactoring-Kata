package scorings.impl;

import models.DicesRoll;
import scorings.ScoringStrategy;
import utils.DicesCountUtil;
import utils.DicesRollValidatorUtil;

public class NOfKindScoring implements ScoringStrategy {

    protected int targetValue;

    public NOfKindScoring(int targetValue) {
        this.targetValue = targetValue;
    }

    public NOfKindScoring() {
        this.targetValue = 3;
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {
        validateDicesRoll(dicesRoll);

        int[] elementsCount = DicesCountUtil.getElementsCount(dicesRoll);
        for (int index = 0; index < dicesRoll.getDiceFacets(); index++) {
            if (elementsCount[index] >= this.targetValue) {
                return (index + 1) * this.targetValue;
            }
        }
        return 0;
    }

    @Override
    public String getScoringStrategyName() {
        return "DEFAULT";
    }

    private void validateDicesRoll(DicesRoll dicesRoll) {
        DicesRollValidatorUtil.validateDicesRoll(dicesRoll);
    }
}
