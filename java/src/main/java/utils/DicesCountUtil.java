package utils;

import constants.YatzyConstants;
import models.DicesRoll;
import validators.DicesRollValidator;
import validators.DicesRollValidatorImpl;

public class GameUtil {

    private static DicesRollValidator dicesRollValidator = new DicesRollValidatorImpl();

    public static int[] getElementsCount(DicesRoll diceRoll) {
        if (!dicesRollValidator.isDicesRollValid(diceRoll)) {
            throw new IllegalArgumentException(YatzyConstants.INVALID_DICES_ROLL);
        }
        int[] elementsCount = new int[diceRoll.getDiceFacets()];
        for (int element : diceRoll.getDices()) {
            elementsCount[element - 1] += 1;
        }

        return elementsCount;
    }

}
