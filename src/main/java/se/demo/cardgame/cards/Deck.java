package se.demo.cardgame.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    ArrayList<Card> deck = new ArrayList<Card>();
    public Deck(){
        for (int i = 0; i < 4; i++){
            for (int j = 2; j < 15; j++){
                Suit suit;
                switch (i){
                    case 0: suit = Suit.SPADES; break;
                    case 1: suit = Suit.CLUBS; break;
                    case 2: suit = Suit.DIAMONDS; break;
                    case 3: suit = Suit.HEARTS; break;
                    default: suit = Suit.SPADES;
                }
                deck.add(new Card(j,suit));
            }
        }
    }
    public void printDeck(){
        for (Card card : deck){
            System.out.println(card);
        }
    }
    public void shuffle(){
        Collections.shuffle(deck);
    }
    public Card drawCard(){
        Card card = deck.removeFirst();
        return card;
    }
    public void discardCard(Card card){
        deck.remove(card);
    }
    public void addCard(Card card){deck.add(card);}
}
