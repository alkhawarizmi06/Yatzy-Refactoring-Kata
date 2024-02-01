package scorerImpl;

import model.DiceList;
import scorer.GameScorer;

public class SinglePairScorer implements GameScorer {

    @Override
    public int computeScore(DiceList diceList) {
       
        if (diceList == null)
            throw new IllegalArgumentException("dices list should not be null");
    
        int[] counts = new int[6];
        counts[diceList.getDices()[0]-1]++;
        counts[diceList.getDices()[1]-1]++;
        counts[diceList.getDices()[2]-1]++;
        counts[diceList.getDices()[3]-1]++;
        counts[diceList.getDices()[4]-1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6-at-1] >= 2)
                return (6-at)*2;
        return 0;
    }
    
}
