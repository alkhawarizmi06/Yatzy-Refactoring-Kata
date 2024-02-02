package scoring;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import constants.YatzyConstants;
import model.DicesRoll;
import scoring.impl.FourOfKindScoring;

public class FourOfKindScoringTest {

    private FourOfKindScoring fourOfKindScoring = new FourOfKindScoring();

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(12,
                        fourOfKindScoring.computeScore(new DicesRoll(new int[] { 3, 3, 3, 3, 5 }))),
                () -> Assertions.assertEquals(20,
                        fourOfKindScoring.computeScore(new DicesRoll(new int[] { 5, 5, 5, 4, 5 }))),
                () -> Assertions.assertEquals(0,
                        fourOfKindScoring.computeScore(new DicesRoll(new int[] { 3, 3, 3, 6, 6 }))));
    }

    @Test
    void shouldThrowExceptionIfDicesRollIsNotValid() {
        int[] dices = new int[] { 5, 4, 5, 3, 7 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            fourOfKindScoring.computeScore(dicesRoll);
        });

        String expectedMessage = YatzyConstants.INVALID_DICES_ROLL;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
