package scorings;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import constants.YatzyConstants;
import models.DicesRoll;
import scorings.impl.SmallStraightScoring;

class SmallStraightScoringTest {

    private SmallStraightScoring smallStraightScoring = new SmallStraightScoring();

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(15,
                        smallStraightScoring.computeScore(new DicesRoll(new int[] { 1, 2, 3, 4, 5 }))),
                () -> Assertions.assertEquals(15,
                        smallStraightScoring.computeScore(new DicesRoll(new int[] { 2, 3, 4, 5, 1 }))),
                () -> Assertions.assertEquals(0,
                        smallStraightScoring.computeScore(new DicesRoll(new int[] { 1, 2, 2, 4, 5 }))));
    }

    @Test
    void shouldThrowExceptionIfDicesRollIsNotValid() {
        int[] dices = new int[] { 5, 4, 5, 3, 7 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            smallStraightScoring.computeScore(dicesRoll);
        });

        String expectedMessage = YatzyConstants.INVALID_DICES_ROLL;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
