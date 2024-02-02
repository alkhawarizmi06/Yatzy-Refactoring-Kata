package scorings;

import models.DicesRoll;

public interface GameScorer {
    public int computeScore(DicesRoll dicesRoll);

    public String getScoringStrategyName();
}