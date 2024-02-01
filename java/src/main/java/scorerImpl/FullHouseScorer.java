package scorerImpl;

import model.DiceList;
import scorer.GameScorer;

public class FullHouseScorer implements GameScorer {

    @Override
    public int computeScore(DiceList diceList) {

        if (diceList == null)
            throw new IllegalArgumentException("dices list should not be null");

            int[] tallies;
            boolean _2 = false;
            int i;
            int _2_at = 0;
            boolean _3 = false;
            int _3_at = 0;
    
            tallies = new int[6];
            tallies[diceList.getDices()[0] - 1] += 1;
            tallies[diceList.getDices()[1] - 1] += 1;
            tallies[diceList.getDices()[2] - 1] += 1;
            tallies[diceList.getDices()[3] - 1] += 1;
            tallies[diceList.getDices()[4] - 1] += 1;
    
            for (i = 0; i != 6; i += 1)
                if (tallies[i] == 2) {
                    _2 = true;
                    _2_at = i + 1;
                }
    
            for (i = 0; i != 6; i += 1)
                if (tallies[i] == 3) {
                    _3 = true;
                    _3_at = i + 1;
                }
    
            if (_2 && _3)
                return _2_at * 2 + _3_at * 3;
            else
                return 0;
    }

}
