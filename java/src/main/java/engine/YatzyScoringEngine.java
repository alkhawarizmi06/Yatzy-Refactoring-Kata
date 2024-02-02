package engine;

import model.DicesRoll;

public interface YatzyScoringEngine {

   public int computeScore(String scoringStrategyName, DicesRoll dicesRoll);

   public int getScoringStrategiesCount();

}
