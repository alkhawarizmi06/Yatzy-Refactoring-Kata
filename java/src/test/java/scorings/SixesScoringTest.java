package scorings;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import constants.YatzyConstants;
import models.DicesRoll;
import scorings.impl.SixesScoring;

class SixesScoringTest {

    private SixesScoring sixesScoring = new SixesScoring();

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(6,
                        sixesScoring.computeScore(new DicesRoll(new int[] { 6, 2, 3, 4, 5 }))),
                () -> Assertions.assertEquals(24,
                        sixesScoring.computeScore(new DicesRoll(new int[] { 6, 2, 6, 6, 6 }))),
                () -> Assertions.assertEquals(0,
                        sixesScoring.computeScore(new DicesRoll(new int[] { 1, 2, 2, 4, 5 }))));
    }

    @Test
    void shouldThrowExceptionIfDicesRollIsNotValid() {
        int[] dices = new int[] { 5, 4, 5, 3, 7 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            sixesScoring.computeScore(dicesRoll);
        });

        String expectedMessage = YatzyConstants.INVALID_DICES_ROLL;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
