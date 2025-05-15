package se.demo.cardgame.user;

import se.demo.cardgame.cards.Card;
import se.demo.cardgame.cards.Deck;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Dealer extends User {
    Deck deck;

    public Dealer() {
        super();
        deck = new Deck();
    }

    public Dealer(ArrayList<Card> cards) {
        super();
        deck = new Deck(cards);
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
    public void printHiddenHand(){
        System.out.println("Dealer's hand is: ");
        System.out.println(super.getCard(0));
        System.out.println("Hidden Card");
    }

}
