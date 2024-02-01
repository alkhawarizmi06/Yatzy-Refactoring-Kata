package scorerImpl;

import java.util.Arrays;

import model.DicesRoll;
import scorer.GameScorer;
import util.GameUtil;

public class FullHouseScorer implements GameScorer {

    private static final int FULL_DEFAULT_SCORE = 0;
    private static final int FULL_SUM = 5;
    private static final int FULL_NUMBER = 2;

    @Override
    public int computeScore(DicesRoll dicesRoll) {

        if (dicesRoll == null) {
            throw new IllegalArgumentException("dices list should not be null");
        }

        int[] elementsCount = GameUtil.getElementsCount(dicesRoll);
        int[] result = Arrays.stream(elementsCount).filter(e -> e != 0).toArray();

        if (result.length == FULL_NUMBER && Arrays.stream(result).sum() == FULL_SUM) {
            return Arrays.stream(dicesRoll.getDices()).sum();
        }

        return FULL_DEFAULT_SCORE;
    }

}
