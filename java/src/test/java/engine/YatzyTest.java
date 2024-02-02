package engine;



public class YatzyTest {

    /*private YatzyScoringEngine scoringEngine = new YatzyScoringEngineImpl(new DicesRollValidatorImpl());

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = scoringEngine.chance(new DicesRoll(new int[] { 2, 3, 4, 5, 1 }));
        assertEquals(expected, actual);
        assertEquals(16, scoringEngine.chance(new DicesRoll(new int[] { 3, 3, 4, 5, 1 })));
    }

    @Test
    public void yatzy_scores_50() {
        int expected = 50;
        int actual = scoringEngine.yatzy(new DicesRoll(new int[] { 4, 4, 4, 4, 4 }));
        Assertions.as(expected, actual);
        assertEquals(50, scoringEngine.yatzy(new DicesRoll(new int[] { 6, 6, 6, 6, 6 })));
        assertEquals(0, scoringEngine.yatzy(new DicesRoll(new int[] { 6, 6, 6, 6, 3 })));
    }

    @Test
    public void test_1s() {
        assertTrue(scoringEngine.ones(new DicesRoll(new int[] { 1, 2, 3, 4, 5 })) == 1);
        assertEquals(2, scoringEngine.ones(new DicesRoll(new int[] { 1, 2, 1, 4, 5 })));
        assertEquals(0, scoringEngine.ones(new DicesRoll(new int[] { 6, 2, 2, 4, 5 })));
        assertEquals(4, scoringEngine.ones(new DicesRoll(new int[] { 1, 2, 1, 1, 1 })));
    }

    @Test
    public void test_2s() {
        assertEquals(4, scoringEngine.twos(new DicesRoll(new int[] { 1, 2, 3, 2, 6 })));
        assertEquals(10, scoringEngine.twos(new DicesRoll(new int[] { 2, 2, 2, 2, 2 })));
    }

    @Test
    public void test_threes() {
        assertEquals(6, scoringEngine.threes(new DicesRoll(new int[] { 1, 2, 3, 2, 3 })));
        assertEquals(12, scoringEngine.threes(new DicesRoll(new int[] { 2, 3, 3, 3, 3 })));
    }

    @Test
    public void fours_test() {
        assertEquals(12, scoringEngine.fours(new DicesRoll(new int[] { 4, 4, 4, 5, 5 })));
        assertEquals(8, scoringEngine.fours(new DicesRoll(new int[] { 4, 4, 5, 5, 5 })));
        assertEquals(4, scoringEngine.fours(new DicesRoll(new int[] { 4, 5, 5, 5, 5 })));
    }

    @Test
    public void fives() {
        assertEquals(10, scoringEngine.fives(new DicesRoll(new int[] { 4, 4, 4, 5, 5 })));
        assertEquals(15, scoringEngine.fives(new DicesRoll(new int[] { 4, 4, 5, 5, 5 })));
        assertEquals(20, scoringEngine.fives(new DicesRoll(new int[] { 4, 5, 5, 5, 5 })));
    }

    @Test
    public void sixes_test() {
        assertEquals(0, scoringEngine.sixes(new DicesRoll(new int[] { 4, 4, 4, 5, 5 })));
        assertEquals(6, scoringEngine.sixes(new DicesRoll(new int[] { 4, 4, 6, 5, 5 })));
        assertEquals(18, scoringEngine.sixes(new DicesRoll(new int[] { 6, 5, 6, 6, 5 })));
    }

    @Test
    public void one_pair() {
        assertEquals(6, scoringEngine.singlePair(new DicesRoll(new int[] { 3, 4, 3, 5, 6 })));
        assertEquals(10, scoringEngine.singlePair(new DicesRoll(new int[] { 5, 3, 3, 3, 5 })));
        assertEquals(12, scoringEngine.singlePair(new DicesRoll(new int[] { 5, 3, 6, 6, 5 })));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, scoringEngine.twoPairs(new DicesRoll(new int[] { 3, 3, 5, 4, 5 })));
        assertEquals(16, scoringEngine.twoPairs(new DicesRoll(new int[] { 3, 3, 5, 5, 5 })));
    }

    @Test
    public void three_of_a_kind() {
        assertEquals(9, scoringEngine.threeOfAKind(new DicesRoll(new int[] { 3, 3, 3, 4, 5 })));
        assertEquals(15, scoringEngine.threeOfAKind(new DicesRoll(new int[] { 5, 3, 5, 4, 5 })));
        assertEquals(9, scoringEngine.threeOfAKind(new DicesRoll(new int[] { 3, 3, 3, 3, 5 })));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, scoringEngine.fourOfAKind(new DicesRoll(new int[] { 3, 3, 3, 3, 5 })));
        assertEquals(20, scoringEngine.fourOfAKind(new DicesRoll(new int[] { 5, 5, 5, 4, 5 })));
        assertEquals(9, scoringEngine.threeOfAKind(new DicesRoll(new int[] { 3, 3, 3, 3, 3 })));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, scoringEngine.smallStraight(new DicesRoll(new int[] { 1, 2, 3, 4, 5 })));
        assertEquals(15, scoringEngine.smallStraight(new DicesRoll(new int[] { 2, 3, 4, 5, 1 })));
        assertEquals(0, scoringEngine.smallStraight(new DicesRoll(new int[] { 1, 2, 2, 4, 5 })));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, scoringEngine.largeStraight(new DicesRoll(new int[] { 6, 2, 3, 4, 5 })));
        assertEquals(20, scoringEngine.largeStraight(new DicesRoll(new int[] { 2, 3, 4, 5, 6 })));
        assertEquals(0, scoringEngine.largeStraight(new DicesRoll(new int[] { 1, 2, 2, 4, 5 })));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, scoringEngine.fullHouse(new DicesRoll(new int[] { 6, 2, 2, 2, 6 })));
        assertEquals(0, scoringEngine.fullHouse(new DicesRoll(new int[] { 2, 3, 4, 5, 6 })));
    }*/
}
