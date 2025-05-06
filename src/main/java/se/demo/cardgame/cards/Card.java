package se.demo.cardgame.cards;

public class Card {
    int value;
    Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        String valueName;
        switch (value) {
            case 11: valueName = "Jack"; break;
            case 12: valueName = "Queen"; break;
            case 13: valueName = "King"; break;
            case 14: valueName = "Ace"; break;
            default: valueName = String.valueOf(value);
        }
        return valueName + " of " + suit.toString();
    }
}
