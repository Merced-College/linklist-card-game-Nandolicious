import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        deck.shuffle();

        // Initialize hands
        Hand playerHand = new Hand();
        Hand dealerHand = new Hand();

        // Deal initial cards
        playerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());

        // Show initial hands
        System.out.println("Your hand: " + playerHand + " (Total: " + playerHand.getValue() + ")");
        System.out.println("Dealer's hand: [" + dealerHand + "] and [Hidden]");

        // Player's turn
        while (true) {
            System.out.println("Would you like to 'hit' or 'stand'?");
            String action = scanner.nextLine().toLowerCase();

            if (action.equals("hit")) {
                playerHand.addCard(deck.dealCard());
                System.out.println("Your hand: " + playerHand + " (Total: " + playerHand.getValue() + ")");

                if (playerHand.getValue() > 21) {
                    System.out.println("Bust! You lose.");
                    return;
                }
            } else if (action.equals("stand")) {
                break;
            } else {
                System.out.println("Invalid action. Please type 'hit' or 'stand'.");
            }
        }

        // Dealer's turn
        System.out.println("Dealer's hand: " + dealerHand + " (Total: " + dealerHand.getValue() + ")");
        while (dealerHand.getValue() < 17) {
            dealerHand.addCard(deck.dealCard());
            System.out.println("Dealer's hand: " + dealerHand + " (Total: " + dealerHand.getValue() + ")");
        }

        // Determine the winner
        int playerTotal = playerHand.getValue();
        int dealerTotal = dealerHand.getValue();

        if (dealerTotal > 21 || playerTotal > dealerTotal) {
            System.out.println("You win!");
        } else if (playerTotal == dealerTotal) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("Dealer wins!");
        }
    }
}