package utils;

import models.DicesRoll;

public class DicesCountUtil {

    public static int[] getElementsCount(DicesRoll dicesRoll) {
        DicesRollValidatorUtil.validateDicesRoll(dicesRoll);

        return countElements(dicesRoll);

    }

    private static int[] countElements(DicesRoll dicesRoll) {
        int[] elementsCount = new int[dicesRoll.getDiceFacets()];
        for (int element : dicesRoll.getDices()) {
            elementsCount[element - 1] += 1;
        }
        return elementsCount;
    }
}
