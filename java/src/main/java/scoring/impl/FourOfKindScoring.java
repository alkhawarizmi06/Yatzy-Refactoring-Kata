package scoring.impl;

import enums.ScoringStrategyEnum;

public class FourOfKindScoring extends NOfKindScoring {

    public FourOfKindScoring() {
        this.targetValue = 4;
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.FOUR_OF_KIND_SCORING_STRATEGY.getScoringStrategyName();
    }

}
