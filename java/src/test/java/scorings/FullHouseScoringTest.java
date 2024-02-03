package scorings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.DicesRoll;
import scorings.impl.FullHouseScoring;

class FullHouseScoringTest extends ScoringStrategyTest {

    public FullHouseScoringTest() {
        super(new FullHouseScoring());
    }

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(18,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 6, 2, 2, 2, 6 }))),
                () -> Assertions.assertEquals(0,
                        scoringStrategy.computeScore(new DicesRoll(new int[] { 2, 3, 4, 5, 6 }))));
    }
}
