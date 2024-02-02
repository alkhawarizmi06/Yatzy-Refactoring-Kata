package utils;

import java.util.Arrays;

import constants.YatzyConstants;
import models.DicesRoll;

public class DicesRollValidatorUtil {

    public static boolean isValidDicesRoll(DicesRoll dicesRoll) {
        return dicesRoll != null &&
                hasValidDices(dicesRoll) &&
                hasValidDiceFacets(dicesRoll);
    }

    public static void validateDicesRoll(DicesRoll dicesRoll) {
        if (!isValidDicesRoll(dicesRoll)) {
            throw new IllegalArgumentException(YatzyConstants.INVALID_DICES_ROLL);
        }
    }

    private static boolean hasValidDices(DicesRoll dicesRoll) {
        int[] dices = dicesRoll.getDices();
        return dices != null
                && Arrays.stream(dices).allMatch(dice -> isValidDiceValue(dice, dicesRoll.getDiceFacets()));
    }

    private static boolean isValidDiceValue(int dice, int maxDiceFacet) {
        return dice >= 1 && dice <= maxDiceFacet;
    }

    private static boolean hasValidDiceFacets(DicesRoll dicesRoll) {
        return dicesRoll.getDiceFacets() > 0;
    }
}
