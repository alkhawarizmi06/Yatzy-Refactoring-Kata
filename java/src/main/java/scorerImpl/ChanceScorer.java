package scorerImpl;

import java.util.Arrays;

import model.DiceList;
import scorer.GameScorer;

public class ChanceScorer implements GameScorer {

    @Override
    public int computeScore(DiceList diceList) {
       
        if (diceList == null)
            throw new IllegalArgumentException("dices list should not be null");
    
        return Arrays.stream(diceList.getDices()).sum();
    }
    
}
