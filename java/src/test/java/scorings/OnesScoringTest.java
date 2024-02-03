package scorings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.DicesRoll;
import scorings.impl.OnesScoring;

class OnesScoringTest extends ScoringStrategyTest {

    public OnesScoringTest() {
        super(new OnesScoring());
    }

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(1,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 1, 2, 3, 4, 5 }))),
                () -> Assertions.assertEquals(4,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 1, 2, 1, 1, 1 }))),
                () -> Assertions.assertEquals(0,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 6, 2, 2, 4, 5 }))));
    }

}
