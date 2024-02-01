package scorerImpl;

import model.DicesRoll;
import scorer.GameScorer;
import util.GameUtil;

public class SmallStraightScorer implements GameScorer {

    @Override
    public int computeScore(DicesRoll dicesRoll) {

        if (dicesRoll == null) {
            throw new IllegalArgumentException("dices list should not be null");
        }

        int[] elementsCount = GameUtil.getElementsCount(dicesRoll);
        for (int index = 0; index < dicesRoll.getDices().length; index++) {
            if (elementsCount[index] != 1) {
                return 0;
            }
        }

        return 15;
    }

}
