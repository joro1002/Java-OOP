package CardsWithPower;

public class Card {
    private RankPower rankPower;
    private SuitPower suitPower;
    private int power;

    public Card(RankPower rankPower, SuitPower suitPower) {
        this.rankPower = rankPower;
        this.suitPower = suitPower;
    }

    public int getPower(){
        return this.rankPower.getRankPower() + this.suitPower.getSuitPower();
    }

    public RankPower getRankPower() {
        return rankPower;
    }

    public SuitPower getSuitPower() {
        return suitPower;
    }
}
