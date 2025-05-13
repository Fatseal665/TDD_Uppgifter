package se.demo.cardgame.user;

import se.demo.cardgame.cards.Deck;

public class Dealer extends User {
    Deck deck;

    public Dealer() {
        super();
        deck = new Deck();
    }

    @Override
    public void printHand(){
        System.out.println("Dealer's hand is: ");
        super.printHand();
    }
    @Override
    public String toString() {
        return "Dealer";
    }
    public void dealerShuffle(){
        deck.shuffle();
    }
    public Deck getDeck() {
        return deck;
    }

}
