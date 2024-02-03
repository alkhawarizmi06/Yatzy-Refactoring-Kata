package scorings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.DicesRoll;
import scorings.impl.FourOfKindScoring;

class FourOfKindScoringTest extends ScoringStrategyTest {

    public FourOfKindScoringTest() {
        super(new FourOfKindScoring());

    }

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(12,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 3, 3, 3, 3, 5 }))),
                () -> Assertions.assertEquals(20,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 5, 5, 5, 4, 5 }))),
                () -> Assertions.assertEquals(0,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 3, 3, 3, 6, 6 }))));
    }

}
