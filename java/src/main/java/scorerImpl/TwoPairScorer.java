package scorerImpl;

import model.DiceList;
import scorer.GameScorer;

public class TwoPairScorer implements GameScorer {

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
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }        
        if (n == 2)
            return score * 2;
        else
            return 0;
    }
    
}
