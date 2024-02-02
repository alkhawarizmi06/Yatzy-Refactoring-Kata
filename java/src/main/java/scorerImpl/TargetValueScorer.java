package scorerImpl;

import java.util.Arrays;

import constants.ScoringStrategyEnum;
import constants.YatzyConstants;
import model.DicesRoll;
import scorer.GameScorer;
import validators.DicesRollValidator;
import validators.DicesRollValidatorImpl;

public class TargetValueScorer implements GameScorer {

    private int targetValue = 1;
    private DicesRollValidator dicesRollValidator;

    public TargetValueScorer () {
        this.dicesRollValidator = new DicesRollValidatorImpl();
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {

         if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException(YatzyConstants.INVALID_DICES_ROLL);
        }
        
        return Arrays.stream(dicesRoll.getDices()).map(e -> e == this.targetValue ? e : 0).sum();
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.ONES_SCORING_STRATEGY.getScoringStrategyName();
    }
  
} 
