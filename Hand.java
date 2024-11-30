import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;
    
    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getValue() {
        int total = 0;
        int aces = 0;

        for (Card card : cards) {
            total += card.getValue();
            if (card.getRank().equals("Ace")) {
                aces++;
            }
        }

        // Adjust for Aces
        while (total > 21 && aces > 0) {
            total -= 10; // Count Ace as 1 instead of 11
            aces--;
        }

        return total;
    }

    public String toString() {
        return cards.toString();
    }
}