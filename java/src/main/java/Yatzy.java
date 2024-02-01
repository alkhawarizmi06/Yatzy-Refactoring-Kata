import model.DicesRoll;
import scorer.GameScorer;
import scorerImpl.ChanceScorer;
import scorerImpl.FullHouseScorer;
import scorerImpl.NOfKindScorer;
import scorerImpl.LargeStraightScorer;
import scorerImpl.TargetValueScorer;
import scorerImpl.NumberOfPairsScorer;
import scorerImpl.SmallStraightScorer;
import scorerImpl.YatzyScorer;

public class Yatzy {

    protected int[] dice;

    public Yatzy(int d1, int d2, int d3, int d4, int _5) {
        dice = new int[5];
        dice[0] = d1;
        dice[1] = d2;
        dice[2] = d3;
        dice[3] = d4;
        dice[4] = _5;
    }

    public static int chance(int d1, int d2, int d3, int d4, int d5) {
        DicesRoll dicesRoll = new DicesRoll(new int[] { d1, d2, d3, d4, d5 }, 6);
        GameScorer yatzyScore = new ChanceScorer();
        return yatzyScore.computeScore(dicesRoll);
    }

    public static int yatzy(int... dice) {
        DicesRoll dicesRoll = new DicesRoll(dice, 6);
        GameScorer yatzyScore = new YatzyScorer();
        return yatzyScore.computeScore(dicesRoll);
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        DicesRoll dicesRoll = new DicesRoll(new int[] { d1, d2, d3, d4, d5 }, 6);
        return getTargetValueScore(dicesRoll, 1);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        DicesRoll dicesRoll = new DicesRoll(new int[] { d1, d2, d3, d4, d5 }, 6);
        return getTargetValueScore(dicesRoll, 2);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        DicesRoll dicesRoll = new DicesRoll(new int[] { d1, d2, d3, d4, d5 }, 6);
        return getTargetValueScore(dicesRoll, 3);
    }

    public int fours() {
        DicesRoll dicesRoll = new DicesRoll(dice, 6);
        return getTargetValueScore(dicesRoll, 4);
    }

    public int fives() {
        DicesRoll dicesRoll = new DicesRoll(dice, 6);
        return getTargetValueScore(dicesRoll, 5);
    }

    public int sixes() {
        DicesRoll dicesRoll = new DicesRoll(dice, 6);
        return getTargetValueScore(dicesRoll, 6);
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5) {
        DicesRoll dicesRoll = new DicesRoll(new int[] { d1, d2, d3, d4, d5 }, 6);
        GameScorer gameScorer = new NumberOfPairsScorer(1);
        return gameScorer.computeScore(dicesRoll);
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5) {
        DicesRoll dicesRoll = new DicesRoll(new int[] { d1, d2, d3, d4, d5 }, 6);
        GameScorer gameScorer = new NumberOfPairsScorer(2);
        return gameScorer.computeScore(dicesRoll);
    }

    public static int four_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        DicesRoll dicesRoll = new DicesRoll(new int[] { d1, d2, d3, d4, d5 }, 6);
        GameScorer gameScorer = new NOfKindScorer(4);
        return gameScorer.computeScore(dicesRoll);
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        DicesRoll dicesRoll = new DicesRoll(new int[] { d1, d2, d3, d4, d5 }, 6);
        GameScorer gameScorer = new NOfKindScorer(3);
        return gameScorer.computeScore(dicesRoll);
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        DicesRoll dicesRoll = new DicesRoll(new int[] { d1, d2, d3, d4, d5 }, 6);
        GameScorer gameScorer = new SmallStraightScorer();
        return gameScorer.computeScore(dicesRoll);
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        DicesRoll dicesRoll = new DicesRoll(new int[] { d1, d2, d3, d4, d5 }, 6);
        GameScorer gameScorer = new LargeStraightScorer();
        return gameScorer.computeScore(dicesRoll);
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        DicesRoll dicesRoll = new DicesRoll(new int[] { d1, d2, d3, d4, d5 }, 6);
        GameScorer gameScorer = new FullHouseScorer();
        return gameScorer.computeScore(dicesRoll);
    }

    private static int getTargetValueScore(DicesRoll dicesRoll, int targetValue) {
        GameScorer yatzyScore = new TargetValueScorer(targetValue);
        return yatzyScore.computeScore(dicesRoll);
    }
}
