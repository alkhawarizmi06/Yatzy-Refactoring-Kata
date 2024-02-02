package scorings;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import constants.YatzyConstants;
import models.DicesRoll;
import scorings.impl.TwoPairsScoring;

class TwoPairsScoringTest {

    private TwoPairsScoring twoPairsScoring = new TwoPairsScoring();

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(16,
                        twoPairsScoring.computeScore(new DicesRoll(new int[] { 3, 3, 5, 4, 5 }))),
                () -> Assertions.assertEquals(20,
                        twoPairsScoring.computeScore(new DicesRoll(new int[] { 4, 4, 6, 4, 6 }))),
                () -> Assertions.assertEquals(0,
                        twoPairsScoring.computeScore(new DicesRoll(new int[] { 6, 1, 2, 4, 5 }))));
    }

    @Test
    void shouldThrowExceptionIfDicesRollIsNotValid() {
        int[] dices = new int[] { 5, 4, 5, 3, 7 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            twoPairsScoring.computeScore(dicesRoll);
        });

        String expectedMessage = YatzyConstants.INVALID_DICES_ROLL;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
