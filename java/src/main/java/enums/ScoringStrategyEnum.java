package enums;

public enum ScoringStrategyEnum {

    CHANCE_SCORING_STRATEGY("chance", "sum of all dicies, example: 1, 2, 3, 4, 5 score = 15"),
    SMALL_STRAIGHT_SCORING_STRATEGY("SMALL_STRAIGHT", "small straight strategy"),
    LARGE_STRAIGHT_SCORING_STRATEGY("LARGE_STRAIGHT", "large straight startegy"),
    SINGLE_PAIR_SCORING_STRATEGY("SINGLE_PAIR", "One pair scoring strategy"),
    TWO_PAIRS_SCORING_STRATEGY("TWO_PAIRs", "two pairs scoring strategy"),
    ONES_SCORING_STRATEGY("ONES", "all dices are equal to 1"),
    SIXES_SCORING_STRATEGY("SIXES", "all dices are equal to 6"),
    YATZY_SCORING_STRATEGY("YATZY", "yatzy"),
    FOUR_OF_KIND_SCORING_STRATEGY("FOUR_OF_KIND", "four of a kind strategy"),
    TWOS_SCORING_STRATEGY("FOUR_OF_KIND", "four of a kind strategy"),
    THREE_OF_KIND_SCORING_STRATEGY("THREE_OF_KIND", "three of a kind strategy"),
    FULL_HOUSE_SCORING_STRATEGY("FULL_HOUSE", "full house scoring strategy, example: 3, 2, 2, 3, 3");

    private String scoringStrategyName;
    private String scoringStrategyDescription;

    private ScoringStrategyEnum(String scoringStrategyName, String scoringStrategyDescription) {
        this.scoringStrategyName = scoringStrategyName;
        this.scoringStrategyDescription = scoringStrategyDescription;
    }

    public String getScoringStrategyName() {
        return this.scoringStrategyName;
    }

    public String getScoringStrategyDescription() {
        return this.scoringStrategyDescription;
    }

}
