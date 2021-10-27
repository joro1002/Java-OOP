package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rank = scanner.nextLine();
        String suit = scanner.nextLine();

        Card card = new Card(RankPower.valueOf(rank), SuitPower.valueOf(suit));

        System.out.printf("Card name: %s of %s; Card power: %d", card.getRankPower(), card.getSuitPower(), card.getPower());
    }
}
