package util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import constants.YatzyConstants;
import model.DicesRoll;

public class GameUtilTest {

    @Test
    void shouldCountElementsCorrectly() {
        int [] dices = new int[] { 5, 4, 5, 3, 6 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        Assertions.assertArrayEquals(GameUtil.getElementsCount(dicesRoll), new int[] { 0, 0, 1, 1, 2, 1 });
    }

    @Test
    void shouldThrowExceptionIfDicesRollIfNotValid() {
        int [] dices = new int[] { 5, 4, 5, 3, 7 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            GameUtil.getElementsCount(dicesRoll);
        });

        String expectedMessage = YatzyConstants.INVALID_DICES_ROLL;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
