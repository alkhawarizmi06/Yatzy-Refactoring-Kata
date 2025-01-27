package utils;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import constants.YatzyConstants;
import models.DicesRoll;

class DicesCountUtilTest {

    @Test
    void shouldCountElementsCorrectly() {
        int [] dices = new int[] { 5, 4, 5, 3, 6 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        Assertions.assertArrayEquals(new int[] { 0, 0, 1, 1, 2, 1 }, DicesCountUtil.getDicesValueCount(dicesRoll));
    }

    @Test
    void shouldThrowExceptionIfDicesRollIfNotValid() {
        int [] dices = new int[] { 5, 4, 5, 3, 7 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DicesCountUtil.getDicesValueCount(dicesRoll);
        });

        String expectedMessage = YatzyConstants.INVALID_DICES_ROLL;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
