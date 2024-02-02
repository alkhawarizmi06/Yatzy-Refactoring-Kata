package scorerImpl;

import constants.ScoringStrategyEnum;
import constants.YatzyConstants;
import model.DicesRoll;
import scorer.GameScorer;
import util.GameUtil;
import validators.DicesRollValidator;
import validators.DicesRollValidatorImpl;

public class FourOfKindScorer implements GameScorer {

    private DicesRollValidator dicesRollValidator;

    public FourOfKindScorer() {
        this.dicesRollValidator = new DicesRollValidatorImpl();
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {

         if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException(YatzyConstants.INVALID_DICES_ROLL);
        }

        int[] elementsCount = GameUtil.getElementsCount(dicesRoll);
        for (int index = 0; index < dicesRoll.getDiceFacets(); index++)
            if (elementsCount[index] >= 4)
                return (index + 1) * 4;
        return 0;
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.FOUR_OF_KIND_SCORING_STRATEGY.getScoringStrategyName();
    }

}
