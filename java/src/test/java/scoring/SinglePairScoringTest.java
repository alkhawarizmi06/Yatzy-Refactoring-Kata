package scoring;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import constants.YatzyConstants;
import model.DicesRoll;
import scoring.impl.SinglePairScoring;

public class SinglePairScoringTest {

    private SinglePairScoring singlePairScoring = new SinglePairScoring();

    @Test
    void shouldReturnCorrectScore() {
        Assertions.assertAll("Sould return the correct score",
                () -> Assertions.assertEquals(6,
                        singlePairScoring.computeScore(new DicesRoll(new int[] { 3, 4, 3, 5, 6 }))),
                () -> Assertions.assertEquals(10,
                        singlePairScoring.computeScore(new DicesRoll(new int[] { 5, 3, 3, 3, 5 }))),
                () -> Assertions.assertEquals(0,
                        singlePairScoring.computeScore(new DicesRoll(new int[] { 6, 1, 2, 4, 5 }))));
    }

    @Test
    void shouldThrowExceptionIfDicesRollIsNotValid() {
        int[] dices = new int[] { 5, 4, 5, 3, 7 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            singlePairScoring.computeScore(dicesRoll);
        });

        String expectedMessage = YatzyConstants.INVALID_DICES_ROLL;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
