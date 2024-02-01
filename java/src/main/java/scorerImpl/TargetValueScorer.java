package scorerImpl;

import java.util.Arrays;

import model.DicesRoll;
import scorer.GameScorer;

public class TargetValueScorer implements GameScorer {

    private int targetValue;

    public TargetValueScorer (int targetValue) {
        this.targetValue = targetValue;
    }

    @Override
    public int computeScore(DicesRoll dicesRoll) {
        if (dicesRoll == null) {
            throw new IllegalArgumentException("dices list should not be null");
        }
        
        return Arrays.stream(dicesRoll.getDices()).map(e -> e == this.targetValue ? e : 0).sum();
    }
  
} 
