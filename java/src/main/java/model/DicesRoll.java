package model;

public class DicesRoll {

    private int[] dices;
    private int diceFacets;

    public DicesRoll(int dices[], int diceFacets) {
        this.dices = dices;
        this.diceFacets = diceFacets;
    }

    public int[] getDices() {
        return this.dices;
    }

    public int getDiceFacets() {
        return this.diceFacets;
    }

}
