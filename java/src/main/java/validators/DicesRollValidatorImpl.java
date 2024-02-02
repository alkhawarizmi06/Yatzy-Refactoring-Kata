package validators;

import java.util.Arrays;

import models.DicesRoll;

public class DicesRollValidatorImpl implements DicesRollValidator {

    @Override
    public boolean isDicesRollValid(DicesRoll dicesRoll) {
        if (dicesRoll == null) {
            return false;
        }

        if (dicesRoll.getDices() == null) {
            return false;
        }

        if (dicesRoll.getDiceFacets() <= 0) {
            return false;
        }

        if (Arrays.stream(dicesRoll.getDices()).filter(dice -> dice < 1 || dice > dicesRoll.getDiceFacets()).toArray().length > 0) {
            return false;
        }

        return true;
    }
    
}
