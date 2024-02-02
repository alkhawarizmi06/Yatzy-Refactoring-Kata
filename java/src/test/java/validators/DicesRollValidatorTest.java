package validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.DicesRoll;

public class DicesRollValidatorTest {

    private DicesRollValidator dicesRollValidator = new DicesRollValidatorImpl();
    @Test
    void shouldReturnFalseForInvalidDicesRoll() {
        Assertions.assertAll("Dices roll is not valid",
                () -> Assertions.assertFalse(this.dicesRollValidator.isDicesRollValid(null)),
                () -> Assertions.assertFalse(this.dicesRollValidator.isDicesRollValid(new DicesRoll(null))),
                () -> Assertions.assertFalse(this.dicesRollValidator.isDicesRollValid(new DicesRoll(new int[]{1,2,3,4,0},6))),
                () -> Assertions.assertFalse(this.dicesRollValidator.isDicesRollValid(new DicesRoll(new int[]{1,2,3,4,0}))));
    }

     @Test
    void shouldReturnTrueForValidDicesRoll() {
        Assertions.assertAll("Dices roll is not valid",
                () -> Assertions.assertTrue(this.dicesRollValidator.isDicesRollValid(new DicesRoll(new int[]{1,2,3,4,5},6))),
                () -> Assertions.assertTrue(this.dicesRollValidator.isDicesRollValid(new DicesRoll(new int[]{1,4,3,4,4}))));
    }
}
