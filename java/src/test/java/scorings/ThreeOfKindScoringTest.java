package scorings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.DicesRoll;
import scorings.impl.ThreeOfKindScoring;

class ThreeOfKindScoringTest extends ScoringStrategyTest {

    public ThreeOfKindScoringTest() {
        super(new ThreeOfKindScoring());
    }

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(9,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 3, 3, 3, 4, 5 }))),
                () -> Assertions.assertEquals(15,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 5, 3, 5, 4, 5 }))),
                () -> Assertions.assertEquals(0,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 3, 3, 1, 2, 4 }))));
    }
}
