package scorer;

import model.DicesRoll;

public interface GameScorer {
    public int computeScore(DicesRoll dicesRoll);
}