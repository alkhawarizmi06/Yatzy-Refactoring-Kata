package scoring.impl;

import enums.ScoringStrategyEnum;

public class TwoPairsScoring extends NumberOfPairsScoring {

    public TwoPairsScoring () {
         this.numberOfPairsTarget = 2;
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.TWO_PAIRS_SCORING_STRATEGY.getScoringStrategyName();
    }

}
