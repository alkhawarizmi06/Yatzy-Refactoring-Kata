package scorings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.DicesRoll;
import scorings.impl.YatzyScoring;

class YatzyScoringTest extends ScoringStrategyTest {

    public YatzyScoringTest() {
        super(new YatzyScoring());
    }

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(50,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 4, 4, 4, 4, 4 }))),
                () -> Assertions.assertEquals(50,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 6, 6, 6, 6, 6 }))),
                () -> Assertions.assertEquals(0,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 4, 4, 4, 4, 6 }))));
    }

}
