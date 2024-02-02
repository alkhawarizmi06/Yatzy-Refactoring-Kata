package scorerImpl;

import constants.ScoringStrategyEnum;
import constants.YatzyConstants;
import model.DicesRoll;
import scorer.GameScorer;
import util.GameUtil;
import validators.DicesRollValidator;
import validators.DicesRollValidatorImpl;

public class YatzyScorer implements GameScorer {

    private DicesRollValidator dicesRollValidator;

    public YatzyScorer() {
        this.dicesRollValidator = new DicesRollValidatorImpl();
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException(YatzyConstants.INVALID_DICES_ROLL);
        }

        int[] elementsCount = GameUtil.getElementsCount(dicesRoll);
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
