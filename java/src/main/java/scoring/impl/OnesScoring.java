package scoring.impl;

import enums.ScoringStrategyEnum;

public class OnesScoring extends TargetValueScoring {

    public OnesScoring() {
        this.targetValue = 1;
    }

    @Override
    public String getScoringStrategyName() {
        return ScoringStrategyEnum.ONES_SCORING_STRATEGY.getScoringStrategyName();
    }

}
