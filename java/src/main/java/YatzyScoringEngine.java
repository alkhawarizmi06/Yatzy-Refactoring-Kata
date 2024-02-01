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
import validators.DicesRollValidator;

public class YatzyScoringEngine {

    private DicesRollValidator dicesRollValidator;

    public YatzyScoringEngine (DicesRollValidator dicesRollValidator) {
        this.dicesRollValidator = dicesRollValidator;
    }

    public int chance(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException("Dices roll is not valid !");
        }

        GameScorer yatzyScore = new ChanceScorer();
        return yatzyScore.computeScore(dicesRoll);
    }

    public int yatzy(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException("Dices roll is not valid !");
        }

        GameScorer yatzyScore = new YatzyScorer();
        return yatzyScore.computeScore(dicesRoll);
    }

    public int ones(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException("Dices roll is not valid !");
        }

        return getTargetValueScore(dicesRoll, 1);
    }

    public int twos(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException("Dices roll is not valid !");
        }

        return getTargetValueScore(dicesRoll, 2);
    }

    public int threes(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException("Dices roll is not valid !");
        }

        return getTargetValueScore(dicesRoll, 3);
    }

    public int fours(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException("Dices roll is not valid !");
        }

        return getTargetValueScore(dicesRoll, 4);
    }

    public int fives(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException("Dices roll is not valid !");
        }

        return getTargetValueScore(dicesRoll, 5);
    }

    public int sixes(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException("Dices roll is not valid !");
        }

        return getTargetValueScore(dicesRoll, 6);
    }

    public int score_pair(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException("Dices roll is not valid !");
        }

        GameScorer gameScorer = new NumberOfPairsScorer(1);
        return gameScorer.computeScore(dicesRoll);
    }

    public int two_pair(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException("Dices roll is not valid !");
        }

        GameScorer gameScorer = new NumberOfPairsScorer(2);
        return gameScorer.computeScore(dicesRoll);
    }

    public int three_of_a_kind(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException("Dices roll is not valid !");
        }

        GameScorer gameScorer = new NOfKindScorer(3);
        return gameScorer.computeScore(dicesRoll);
    }

    public int four_of_a_kind(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException("Dices roll is not valid !");
        }

        GameScorer gameScorer = new NOfKindScorer(4);
        return gameScorer.computeScore(dicesRoll);
    }

    public int smallStraight(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException("Dices roll is not valid !");
        }

        GameScorer gameScorer = new SmallStraightScorer();
        return gameScorer.computeScore(dicesRoll);
    }

    public int largeStraight(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException("Dices roll is not valid !");
        }

        GameScorer gameScorer = new LargeStraightScorer();
        return gameScorer.computeScore(dicesRoll);
    }

    public int fullHouse(DicesRoll dicesRoll) {

        if (!this.dicesRollValidator.isDicesRollValid(dicesRoll)) {
            throw new IllegalArgumentException("Dices roll is not valid !");
        }
        
        GameScorer gameScorer = new FullHouseScorer();
        return gameScorer.computeScore(dicesRoll);
    }

    private int getTargetValueScore(DicesRoll dicesRoll, int targetValue) {
        GameScorer yatzyScore = new TargetValueScorer(targetValue);
        return yatzyScore.computeScore(dicesRoll);
    }
}
