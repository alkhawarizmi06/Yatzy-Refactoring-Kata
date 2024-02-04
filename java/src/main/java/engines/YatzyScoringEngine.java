package engines;

import exceptions.UnknownScoringStrategyException;
import models.DicesRoll;

public interface YatzyScoringEngine {

   public int computeScore(String scoringStrategyName, DicesRoll dicesRoll) throws UnknownScoringStrategyException;

   public int getScoringStrategiesCount();

}
