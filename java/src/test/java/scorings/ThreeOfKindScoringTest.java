package scorings;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import constants.YatzyConstants;
import models.DicesRoll;
import scorings.impl.ThreeOfKindScoring;

public class ThreeOfKindScoringTest {

    private ThreeOfKindScoring threeOfKindScoring = new ThreeOfKindScoring();

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(9,
                        threeOfKindScoring.computeScore(new DicesRoll(new int[] { 3, 3, 3, 4, 5 }))),
                () -> Assertions.assertEquals(15,
                        threeOfKindScoring.computeScore(new DicesRoll(new int[] { 5, 3, 5, 4, 5 }))),
                () -> Assertions.assertEquals(0,
                        threeOfKindScoring.computeScore(new DicesRoll(new int[] { 3, 3, 1, 2, 4 }))));
    }

    @Test
    void shouldThrowExceptionIfDicesRollIsNotValid() {
        int[] dices = new int[] { 5, 4, 5, 3, 7 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            threeOfKindScoring.computeScore(dicesRoll);
        });

        String expectedMessage = YatzyConstants.INVALID_DICES_ROLL;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
