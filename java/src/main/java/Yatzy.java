import model.DiceList;
import scorer.GameScorer;
import scorerImpl.ChanceScorer;
import scorerImpl.FullHouseScorer;
import scorerImpl.NOfKindScorer;
import scorerImpl.SinglePairScorer;
import scorerImpl.StraightScorer;
import scorerImpl.TargetValueScorer;
import scorerImpl.TwoPairScorer;
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
        DiceList diceList = new DiceList(new int[] { d1, d2, d3, d4, d5 });
        GameScorer yatzyScore = new ChanceScorer();
        return yatzyScore.computeScore(diceList);
    }

    public static int yatzy(int... dice) {
        DiceList diceList = new DiceList(dice);
        GameScorer yatzyScore = new YatzyScorer();
        return yatzyScore.computeScore(diceList);
    }

    public static int ones(int d1, int d2, int d3, int d4, int d5) {
        DiceList diceList = new DiceList(new int[] { d1, d2, d3, d4, d5 });
        return getTargetValueScore(diceList, 1);
    }

    public static int twos(int d1, int d2, int d3, int d4, int d5) {
        DiceList diceList = new DiceList(new int[] { d1, d2, d3, d4, d5 });
        return getTargetValueScore(diceList, 2);
    }

    public static int threes(int d1, int d2, int d3, int d4, int d5) {
        DiceList diceList = new DiceList(new int[] { d1, d2, d3, d4, d5 });
        return getTargetValueScore(diceList, 3);
    }

    public int fours() {
        DiceList diceList = new DiceList(dice);
        return getTargetValueScore(diceList, 4);
    }

    public int fives() {
        DiceList diceList = new DiceList(dice);
        return getTargetValueScore(diceList, 5);
    }

    public int sixes() {
        DiceList diceList = new DiceList(dice);
        return getTargetValueScore(diceList, 6);
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5) {
        DiceList diceList = new DiceList(new int[] { d1, d2, d3, d4, d5 });
        GameScorer gameScorer = new SinglePairScorer();
        return gameScorer.computeScore(diceList);
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5) {
        DiceList diceList = new DiceList(new int[] { d1, d2, d3, d4, d5 });
        GameScorer gameScorer = new TwoPairScorer();
        return gameScorer.computeScore(diceList);
    }

    public static int four_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        DiceList diceList = new DiceList(new int[] { d1, d2, d3, d4, d5 });
        GameScorer gameScorer = new NOfKindScorer(4);
        return gameScorer.computeScore(diceList);
    }

    public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
        DiceList diceList = new DiceList(new int[] { d1, d2, d3, d4, d5 });
        GameScorer gameScorer = new NOfKindScorer(3);
        return gameScorer.computeScore(diceList);
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {
        DiceList diceList = new DiceList(new int[] { d1, d2, d3, d4, d5 });
        GameScorer gameScorer = new StraightScorer(0);
        return gameScorer.computeScore(diceList);
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
        DiceList diceList = new DiceList(new int[] { d1, d2, d3, d4, d5 });
        GameScorer gameScorer = new StraightScorer(1);
        return gameScorer.computeScore(diceList);
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
        DiceList diceList = new DiceList(new int[] { d1, d2, d3, d4, d5 });
        GameScorer gameScorer = new FullHouseScorer();
        return gameScorer.computeScore(diceList);
    }

    private static int getTargetValueScore(DiceList diceList, int targetValue) {
        GameScorer yatzyScore = new TargetValueScorer(targetValue);
        return yatzyScore.computeScore(diceList);
    }
}
