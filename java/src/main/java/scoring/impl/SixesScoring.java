package scoring.impl;

import enums.ScoringStrategyEnum;

public class SixesScoring extends TargetValueScoring {

    public SixesScoring() {
        this.targetValue = 6;
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.SIXES_SCORING_STRATEGY.getScoringStrategyName();
    }

}
