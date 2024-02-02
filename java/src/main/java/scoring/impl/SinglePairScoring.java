package scoring.impl;

import enums.ScoringStrategyEnum;

public class SinglePairScoring extends NumberOfPairsScoring {

    public SinglePairScoring () {
         this.numberOfPairsTarget = 1;
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.SINGLE_PAIR_SCORING_STRATEGY.getScoringStrategyName();
    }

}
