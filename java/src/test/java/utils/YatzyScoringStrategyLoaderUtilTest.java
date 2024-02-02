package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class YatzyScoringStrategyLoaderUtilTest {

    @Test
    void shouldLoadAllScoringStrategies() {

        Assertions.assertEquals(14, YatzyScoringStrategyLoaderUtil.loadScoringStrategies("scorings.impl").size());
    }
}
