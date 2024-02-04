package utils;

import models.DicesRoll;

public class DicesCountUtil {

    public static int[] getDicesValueCount(DicesRoll dicesRoll) {
        DicesRollValidatorUtil.validateDicesRoll(dicesRoll);

        return countDiceValues(dicesRoll);

    }

    private static int[] countDiceValues(DicesRoll dicesRoll) {
        int[] dicesValueCount = new int[dicesRoll.getDiceFacets()];
        for (int element : dicesRoll.getDices()) {
            dicesValueCount[element - 1] += 1;
        }
        return dicesValueCount;
    }
}
