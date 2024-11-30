import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CardGame {

    private static LinkList cardList = new LinkList(); // Initialize card list

    public static void main(String[] args) {
        String fileName = "cards.txt";

        // Read the file and create Card objects
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] details = line.split(","); 
                if (details.length == 4) {
                    String suit = details[0].trim();
                    String name = details[1].trim();
                    int value = Integer.parseInt(details[2].trim());
                    String pic = details[3].trim();

                    Card card = new Card(suit, name, value, pic);
                    cardList.add(card);
                } else {
                    System.err.println("Invalid line format: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        System.out.println("Deck before shuffling:");
        cardList.displayList();

        // Shuffle the deck
        cardList.shuffle();

        System.out.println("Deck after shuffling:");
        cardList.displayList();

        // Deal cards to the player
        Card[] playerHand = new Card[5];
        for (int i = 0; i < playerHand.length; i++) {
            playerHand[i] = cardList.getFirst();
        }

        System.out.println("Player's hand:");
        for (Card card : playerHand) {
            System.out.println(card);
        }

        System.out.println("Remaining deck:");
        cardList.displayList();
    }
}