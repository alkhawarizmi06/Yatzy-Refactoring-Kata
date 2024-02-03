package scorings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.DicesRoll;
import scorings.impl.TwoPairsScoring;

class TwoPairsScoringTest extends ScoringStrategyTest {

    public TwoPairsScoringTest() {
        super(new TwoPairsScoring());
    }

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(16,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 3, 3, 5, 4, 5 }))),
                () -> Assertions.assertEquals(20,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 4, 4, 6, 4, 6 }))),
                () -> Assertions.assertEquals(0,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 6, 1, 2, 4, 5 }))));
    }

}
