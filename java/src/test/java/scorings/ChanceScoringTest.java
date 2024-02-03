package scorings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.DicesRoll;
import scorings.impl.ChanceScoring;

class ChanceScoringTest extends ScoringStrategyTest {

    public ChanceScoringTest() {
        super(new ChanceScoring());

    }

    @Test
    void shouldReturnCorrectScore() {
        int[] dices = new int[] { 2, 3, 4, 5, 1 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        int actual = super.scoringStrategy.computeScore(dicesRoll);
        Assertions.assertEquals(15, actual);
    }
}
