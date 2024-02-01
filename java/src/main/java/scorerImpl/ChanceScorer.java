package scorerImpl;

import java.util.Arrays;

import model.DicesRoll;
import scorer.GameScorer;

public class ChanceScorer implements GameScorer {

    @Override
    public int computeScore(DicesRoll dicesRoll) {
       
        if (dicesRoll == null) {
            throw new IllegalArgumentException("dices list should not be null");
        }
    
        return Arrays.stream(dicesRoll.getDices()).sum();
    }
    
}
