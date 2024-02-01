package scorerImpl;

import model.DicesRoll;
import scorer.GameScorer;
import util.GameUtil;

public class YatzyScorer implements GameScorer {

    @Override
    public int computeScore(DicesRoll dicesRoll) {

        if (dicesRoll == null) {
            throw new IllegalArgumentException("dices list should not be null");
        }

        int[] elementsCount = GameUtil.getElementsCount(dicesRoll);
        for (int index = 0; index < dicesRoll.getDiceFacets(); index++)
            if (elementsCount[index] == 5)
                return 50;
        return 0;
    }

}
