package scorings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.DicesRoll;
import scorings.impl.SmallStraightScoring;

class SmallStraightScoringTest extends ScoringStrategyTest {

    public SmallStraightScoringTest() {
        super(new SmallStraightScoring());
    }

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(15,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 1, 2, 3, 4, 5 }))),
                () -> Assertions.assertEquals(15,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 2, 3, 4, 5, 1 }))),
                () -> Assertions.assertEquals(0,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 1, 2, 2, 4, 5 }))));
    }
}
