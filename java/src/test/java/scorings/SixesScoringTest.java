package scorings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.DicesRoll;
import scorings.impl.SixesScoring;

class SixesScoringTest extends ScoringStrategyTest {

    public SixesScoringTest() {
        super(new SixesScoring());
    }

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(6,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 6, 2, 3, 4, 5 }))),
                () -> Assertions.assertEquals(24,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 6, 2, 6, 6, 6 }))),
                () -> Assertions.assertEquals(0,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 1, 2, 2, 4, 5 }))));
    }
}
