package scorerImpl;

import model.DicesRoll;
import scorer.GameScorer;
import util.GameUtil;

public class NOfKindScorer implements GameScorer {

    private int targetValue;

    public NOfKindScorer(int targetValue) {
        this.targetValue = targetValue;
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {

        if (dicesRoll == null) {
            throw new IllegalArgumentException("dices list should not be null");
        }

        int[] elementsCount = GameUtil.getElementsCount(dicesRoll);
        for (int index = 0; index < dicesRoll.getDiceFacets(); index++)
            if (elementsCount[index] >= this.targetValue)
                return (index + 1) * this.targetValue;
        return 0;
    }

}
