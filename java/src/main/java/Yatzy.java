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

    public static int chance(DicesRoll dicesRoll) {
        GameScorer yatzyScore = new ChanceScorer();
        return yatzyScore.computeScore(dicesRoll);
    }

    public static int yatzy(DicesRoll dicesRoll) {
        GameScorer yatzyScore = new YatzyScorer();
        return yatzyScore.computeScore(dicesRoll);
    }

    public static int ones(DicesRoll dicesRoll) {
        return getTargetValueScore(dicesRoll, 1);
    }

    public static int twos(DicesRoll dicesRoll) {
        return getTargetValueScore(dicesRoll, 2);
    }

    public static int threes(DicesRoll dicesRoll) {
        return getTargetValueScore(dicesRoll, 3);
    }

    public static int fours(DicesRoll dicesRoll) {
        return getTargetValueScore(dicesRoll, 4);
    }

    public static int fives(DicesRoll dicesRoll) {
        return getTargetValueScore(dicesRoll, 5);
    }

    public static int sixes(DicesRoll dicesRoll) {
        return getTargetValueScore(dicesRoll, 6);
    }

    public static int score_pair(DicesRoll dicesRoll) {
        GameScorer gameScorer = new NumberOfPairsScorer(1);
        return gameScorer.computeScore(dicesRoll);
    }

    public static int two_pair(DicesRoll dicesRoll) {
        GameScorer gameScorer = new NumberOfPairsScorer(2);
        return gameScorer.computeScore(dicesRoll);
    }

    public static int three_of_a_kind(DicesRoll dicesRoll) {
        GameScorer gameScorer = new NOfKindScorer(3);
        return gameScorer.computeScore(dicesRoll);
    }

    public static int four_of_a_kind(DicesRoll dicesRoll) {
        GameScorer gameScorer = new NOfKindScorer(4);
        return gameScorer.computeScore(dicesRoll);
    }

    public static int smallStraight(DicesRoll dicesRoll) {
        GameScorer gameScorer = new SmallStraightScorer();
        return gameScorer.computeScore(dicesRoll);
    }

    public static int largeStraight(DicesRoll dicesRoll) {
        GameScorer gameScorer = new LargeStraightScorer();
        return gameScorer.computeScore(dicesRoll);
    }

    public static int fullHouse(DicesRoll dicesRoll) {
        GameScorer gameScorer = new FullHouseScorer();
        return gameScorer.computeScore(dicesRoll);
    }

    private static int getTargetValueScore(DicesRoll dicesRoll, int targetValue) {
        GameScorer yatzyScore = new TargetValueScorer(targetValue);
        return yatzyScore.computeScore(dicesRoll);
    }
}
