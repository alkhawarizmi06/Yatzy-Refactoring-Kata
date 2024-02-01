package scorerImpl;

import model.DiceList;
import scorer.GameScorer;

public class YatzyScorer implements GameScorer {

    @Override
    public int computeScore(DiceList diceList) {
        if (diceList == null)
            throw new IllegalArgumentException("Dices list should not be null");
        int[] counts = new int[6];
        for (int die : diceList.getDices())
            counts[die-1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }
  
} 
