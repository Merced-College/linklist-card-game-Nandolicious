import java.util.ArrayList;
import java.util.Collections;

public class LinkList {
    private Link first; // ref to first link on list

    public LinkList() {
        first = null; // no links on list yet
    }

    public void add(Card card) {
        Link newLink = new Link(card);
        newLink.next = first; // it points to old first link
        first = newLink; // now first points to this
    }

    public void shuffle() {
        // Convert linked list to ArrayList for easy shuffling
        ArrayList<Card> cards = new ArrayList<>();
        Link current = first;
        while (current != null) {
            cards.add(current.cardLink);
            current = current.next;
        }

        // Shuffle the ArrayList
        Collections.shuffle(cards);

        // Rebuild the linked list from the shuffled cards
        first = null; // Reset the list
        for (Card card : cards) {
            this.add(card);
        }
    }

    public void displayList() {
        Link current = first; // start at beginning of list
        while (current != null) { // until end of list,
            current.displayLink(); // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }

    public Card getFirst() {
        Link current = first; // search for link
        first = first.next; // change first
        return current.cardLink;
    }
}