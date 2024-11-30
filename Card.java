public class Card {
    private String rank;
    private String suit;
    private int value;
    private String pictureFile; // New field

    public Card(String rank, String suit, int value, String pictureFile) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
        this.pictureFile = pictureFile; // Store the picture file name
    }

    // Getter for rank
    public String getRank() {
        return rank;
    }

    // Getter for suit
    public String getSuit() {
        return suit;
    }

    // Getter for value
    public int getValue() {
        return value;
    }

    // Getter for picture file (if needed)
    public String getPictureFile() {
        return pictureFile;
    }

    // Override toString for card representation
    public String toString() {
        return rank + " of " + suit + " (Value: " + value + ", Picture: " + pictureFile + ")";
    }
}