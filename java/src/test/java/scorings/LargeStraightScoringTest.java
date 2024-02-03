package scorings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.DicesRoll;
import scorings.impl.LargeStraightScoring;

class LargeStraightScoringTest extends ScoringStrategyTest {

    public LargeStraightScoringTest() {
        super(new LargeStraightScoring());
    }

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(20,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 6, 2, 3, 4, 5 }))),
                () -> Assertions.assertEquals(20,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 2, 3, 4, 5, 6 }))),
                () -> Assertions.assertEquals(0,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 1, 2, 2, 4, 5 }))));
    }

}
