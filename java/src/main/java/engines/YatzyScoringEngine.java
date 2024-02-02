package engines;

import models.DicesRoll;

public interface YatzyScoringEngine {

   public int computeScore(String scoringStrategyName, DicesRoll dicesRoll);

   public int getScoringStrategiesCount();

}
