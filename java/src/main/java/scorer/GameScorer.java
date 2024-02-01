package scorer;

import model.DiceList;

public interface GameScorer {
    public int computeScore(DiceList diceList);
}