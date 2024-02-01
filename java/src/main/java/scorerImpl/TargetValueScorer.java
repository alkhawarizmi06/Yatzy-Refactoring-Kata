package scorerImpl;

import java.util.Arrays;

import model.DiceList;
import scorer.GameScorer;

public class TargetValueScorer implements GameScorer {

    private int targetValue;

    public TargetValueScorer (int targetValue) {
        this.targetValue = targetValue;
    }

    @Override
    public int computeScore(DiceList diceList) {
        if (diceList == null)
            throw new IllegalArgumentException("Dices list should not be null");
        
        return Arrays.stream(diceList.getDices()).map(e -> e == this.targetValue ? e : 0).sum();
    }
  
} 
