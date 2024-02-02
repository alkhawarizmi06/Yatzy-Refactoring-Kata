package scorings;

import models.DicesRoll;

public interface ScoringStrategy {
    
    public int computeScore(DicesRoll dicesRoll);

    public String getScoringStrategyName();
}