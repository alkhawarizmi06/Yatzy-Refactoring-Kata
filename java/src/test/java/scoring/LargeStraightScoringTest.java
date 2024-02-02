package scoring;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import constants.YatzyConstants;
import model.DicesRoll;
import scoring.impl.LargeStraightScoring;

public class LargeStraightScoringTest {

    private LargeStraightScoring largeStraightScoring = new LargeStraightScoring();

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(20,
                        largeStraightScoring.computeScore(new DicesRoll(new int[] { 6, 2, 3, 4, 5 }))),
                () -> Assertions.assertEquals(20,
                        largeStraightScoring.computeScore(new DicesRoll(new int[] { 2, 3, 4, 5, 6 }))),
                () -> Assertions.assertEquals(0,
                        largeStraightScoring.computeScore(new DicesRoll(new int[] { 1, 2, 2, 4, 5 }))));
    }

    @Test
    void shouldThrowExceptionIfDicesRollIsNotValid() {
        int[] dices = new int[] { 5, 4, 5, 3, 7 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            largeStraightScoring.computeScore(dicesRoll);
        });

        String expectedMessage = YatzyConstants.INVALID_DICES_ROLL;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
