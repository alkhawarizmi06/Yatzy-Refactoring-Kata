package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import models.DicesRoll;

class DicesRollValidatorUtilTest {

    @Test
    void shouldReturnFalseForInvalidDicesRoll() {
        Assertions.assertAll("Dices roll is not valid",
                () -> Assertions.assertFalse(DicesRollValidatorUtil.isValidDicesRoll(null)),
                () -> Assertions.assertFalse(DicesRollValidatorUtil.isValidDicesRoll(new DicesRoll(null))),
                () -> Assertions.assertFalse(
                        DicesRollValidatorUtil.isValidDicesRoll(new DicesRoll(new int[] { 1, 2, 3, 4, 0 }, 6))),
                () -> Assertions.assertFalse(
                        DicesRollValidatorUtil.isValidDicesRoll(new DicesRoll(new int[] { 1, 2, 3, 4, 0 }))));
    }

    @Test
    void shouldReturnTrueForValidDicesRoll() {
        Assertions.assertAll("Dices roll is not valid",
                () -> Assertions.assertTrue(
                        DicesRollValidatorUtil.isValidDicesRoll(new DicesRoll(new int[] { 1, 2, 3, 4, 5 }, 6))),
                () -> Assertions.assertTrue(
                        DicesRollValidatorUtil.isValidDicesRoll(new DicesRoll(new int[] { 1, 4, 3, 4, 4 }))));
    }
}
