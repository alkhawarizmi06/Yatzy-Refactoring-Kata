package scorerImpl;

import model.DicesRoll;
import scorer.GameScorer;
import util.GameUtil;

public class NumberOfPairsScorer implements GameScorer {

    private int numberOfPairsTarget;

    public NumberOfPairsScorer(int numberOfPairsTarget) {
        this.numberOfPairsTarget = numberOfPairsTarget;
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {

        if (dicesRoll == null) {
            throw new IllegalArgumentException("dices list should not be null");
        }

        int[] elementsCount = GameUtil.getElementsCount(dicesRoll);
        int numberOfPairs = 0;
        int currentScore = 0;
        for (int index = elementsCount.length - 1; index >= 0; index--) {
            if (elementsCount[index] >= 2 && numberOfPairs < this.numberOfPairsTarget) {
                numberOfPairs++;
                currentScore += index + 1;
            }
        }

        return currentScore * 2;

    }

}
