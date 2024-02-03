package scorings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.DicesRoll;
import scorings.impl.SinglePairScoring;

class SinglePairScoringTest extends ScoringStrategyTest {

    public SinglePairScoringTest() {
        super(new SinglePairScoring());
    }

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(6,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 3, 4, 3, 5, 6 }))),
                () -> Assertions.assertEquals(10,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 5, 3, 3, 3, 5 }))),
                () -> Assertions.assertEquals(0,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 6, 1, 2, 4, 5 }))));
    }
}
