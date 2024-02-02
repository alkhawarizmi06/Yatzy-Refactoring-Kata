package scorings.impl;

import enums.ScoringStrategyEnum;

public class ThreeOfKindScoring extends NOfKindScoring {

    public ThreeOfKindScoring() {
        this.targetValue = 3;
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.FOUR_OF_KIND_SCORING_STRATEGY.getScoringStrategyName();
    }

}
