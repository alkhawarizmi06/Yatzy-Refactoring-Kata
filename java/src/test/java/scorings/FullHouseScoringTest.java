package scorings;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import constants.YatzyConstants;
import models.DicesRoll;
import scorings.impl.FullHouseScoring;

public class FullHouseScoringTest {

    private FullHouseScoring fullHouseScoring  = new FullHouseScoring();

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(18, fullHouseScoring.computeScore(new DicesRoll(new int[] { 6, 2, 2, 2, 6 }))),
                () -> Assertions.assertEquals(0, fullHouseScoring.computeScore(new DicesRoll(new int[] { 2, 3, 4, 5, 6 }))));
    }

    @Test
    void shouldThrowExceptionIfDicesRollIsNotValid() {
        int [] dices = new int[] { 5, 4, 5, 3, 7 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            fullHouseScoring.computeScore(dicesRoll);
        });

        String expectedMessage = YatzyConstants.INVALID_DICES_ROLL;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
