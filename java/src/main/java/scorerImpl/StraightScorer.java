package scorerImpl;

import model.DiceList;
import scorer.GameScorer;

public class StraightScorer implements GameScorer {

    private int startIndex;

    public StraightScorer(int startIndex) {
        this.startIndex = startIndex;
    }

    @Override
    public int computeScore(DiceList diceList) {

        if (diceList == null)
            throw new IllegalArgumentException("dices list should not be null");

        int[] tallies;
        tallies = new int[diceList.getDices().length];
        for (int index : diceList.getDices()) {
            tallies[index - 1] += 1;
        }

        for (int index = startIndex; index < tallies.length; index++) {
            if (tallies[index] != 1) {
                return 0;
            }
        }

        return 15;
    }

}
