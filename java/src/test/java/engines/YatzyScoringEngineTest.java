package engines;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import constants.YatzyConstants;
import engines.impl.YatzyScoringEngineImpl;
import enums.ScoringStrategyEnum;
import exceptions.UnknownScoringStrategyException;
import models.DicesRoll;

class YatzyScoringEngineTest {

    private YatzyScoringEngine scoringEngine = new YatzyScoringEngineImpl();

    @Test
    void shouldReturnCorrectScoreForChanceScoringStrategy() throws UnknownScoringStrategyException {
        int[] dices = new int[] { 5, 4, 5, 3, 6 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        String scoringStrategyName = ScoringStrategyEnum.CHANCE_SCORING_STRATEGY.getScoringStrategyName();
        int actual = scoringEngine.computeScore(scoringStrategyName, dicesRoll);
        Assertions.assertEquals(23, actual);
    }

    @Test
    void shouldReturnTheRightNumberOfAvailableScoringStrategies() {
        int actual = scoringEngine.getScoringStrategiesCount();
        Assertions.assertEquals(14, actual);
    }

    @Test
    void shouldThrowExceptionIfScoringStrategyDoesNotExists() {
        int [] dices = new int[] { 5, 4, 5, 3, 7 };
        DicesRoll dicesRoll = new DicesRoll(dices, 6);
        Exception exception = assertThrows(UnknownScoringStrategyException.class, () -> {
            scoringEngine.computeScore("UNKNOWN", dicesRoll);
        });

        String expectedMessage = YatzyConstants.UNKNOWN_SCORING_STRATEGY;
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
