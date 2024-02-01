package scorerImpl;

import model.DiceList;
import scorer.GameScorer;

public class NOfKindScorer implements GameScorer {

    private int targetValue;

    public NOfKindScorer (int targetValue) {
        this.targetValue = targetValue;
    }

    @Override
    public int computeScore(DiceList diceList) {
       
        if (diceList == null)
            throw new IllegalArgumentException("dices list should not be null");
    
        int[] tallies;
        tallies = new int[6];
        tallies[diceList.getDices()[0]-1]++;
        tallies[diceList.getDices()[1]-1]++;
        tallies[diceList.getDices()[2]-1]++;
        tallies[diceList.getDices()[3]-1]++;
        tallies[diceList.getDices()[4]-1]++;
        for (int i = 0; i < 6; i++)
            if (tallies[i] >= this.targetValue)
                return (i+1) * this.targetValue;
        return 0;
    }
    
}
