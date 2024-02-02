package scorings;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import constants.YatzyConstants;
import models.DicesRoll;
import scorings.impl.ChanceScoring;

public class ChanceScoringTest {

    private ChanceScoring chanceScoring = new ChanceScoring();

    @Test
    void shouldReturnCorrectScore() {
        int[] dices = new int[] { 2, 3, 4, 5, 1 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        int actual = chanceScoring.computeScore(dicesRoll);
        Assertions.assertEquals(15, actual);
    }

    @Test
    void shouldThrowExceptionIfDicesRollIsNotValid() {
        int [] dices = new int[] { 5, 4, 5, 3, 7 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            chanceScoring.computeScore(dicesRoll);
        });

        String expectedMessage = YatzyConstants.INVALID_DICES_ROLL;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
