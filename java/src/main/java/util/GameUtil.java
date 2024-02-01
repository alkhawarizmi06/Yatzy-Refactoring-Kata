package util;

import model.DicesRoll;

public class GameUtil {

    public static int [] getElementsCount (DicesRoll diceRoll) {
        int[] elementsCount = new int[diceRoll.getDiceFacets()];
        for (int element : diceRoll.getDices()) {
            elementsCount[element - 1] += 1;
        }

        return elementsCount;
    }
    
}
