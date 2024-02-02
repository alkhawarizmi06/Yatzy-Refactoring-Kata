package scorerImpl;

import java.util.Arrays;

import constants.ScoringStrategyEnum;
import constants.YatzyConstants;
import model.DicesRoll;
import scorer.GameScorer;
import validators.DicesRollValidator;
import validators.DicesRollValidatorImpl;

public class ChanceScorer implements GameScorer {

    private DicesRollValidator dicesRollValidator;

    public ChanceScorer () {
         this.dicesRollValidator = new DicesRollValidatorImpl();
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {
       
        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException(YatzyConstants.INVALID_DICES_ROLL);
        }
    
        return Arrays.stream(dicesRoll.getDices()).sum();
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.CHANCE_SCORING_STRATEGY.getScoringStrategyName();
    }
    
}
