package scoring;

import model.DicesRoll;

public interface GameScorer {
    public int computeScore(DicesRoll dicesRoll);

    public String getScoringStrategyName();
}