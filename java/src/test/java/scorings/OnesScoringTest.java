package scorings;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import constants.YatzyConstants;
import models.DicesRoll;
import scorings.impl.OnesScoring;

class OnesScoringTest {

    private OnesScoring onesScoring = new OnesScoring();

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(1,
                        onesScoring.computeScore(new DicesRoll(new int[] { 1, 2, 3, 4, 5 }))),
                () -> Assertions.assertEquals(4,
                        onesScoring.computeScore(new DicesRoll(new int[] { 1, 2, 1, 1, 1 }))),
                () -> Assertions.assertEquals(0,
                        onesScoring.computeScore(new DicesRoll(new int[] { 6, 2, 2, 4, 5 }))));
    }

    @Test
    void shouldThrowExceptionIfDicesRollIsNotValid() {
        int[] dices = new int[] { 5, 4, 5, 3, 7 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            onesScoring.computeScore(dicesRoll);
        });

        String expectedMessage = YatzyConstants.INVALID_DICES_ROLL;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
