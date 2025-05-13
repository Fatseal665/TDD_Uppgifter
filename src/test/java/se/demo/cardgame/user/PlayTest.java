package se.demo.cardgame.user;


import org.junit.jupiter.api.Test;
import se.demo.cardgame.cards.Card;
import se.demo.cardgame.cards.Deck;
import se.demo.cardgame.cards.Suit;
import se.demo.cardgame.mechanics.Play;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayTest {
    @Test
    void testHit() {
        Card card = new Card(2, Suit.SPADES);
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(card);

        Deck deck = new Deck(hand);
        User user = new Player("Player");

        Play.hit(user, deck);

        assertEquals(card, user.getCard(0));
    }


    @Test
    void testDealerIAUnder21() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(10, Suit.SPADES));
        cards.add(new Card(8, Suit.DIAMONDS));
        //This card should not appear
        cards.add(new Card(14, Suit.SPADES));

        Deck deck = new Deck(cards);
        User dealer = new Dealer();

        Play.dealerPlay(dealer, deck);

        assertEquals(18, dealer.getPoints());
    }

    @Test
    void testDealerIAOver21() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(10, Suit.SPADES));
        cards.add(new Card(6, Suit.DIAMONDS));
        cards.add(new Card(8, Suit.CLUBS));
        //This card should not appear
        cards.add(new Card(14, Suit.SPADES));


        Deck deck = new Deck(cards);
        User dealer = new Dealer();

        Play.dealerPlay(dealer, deck);
        assertEquals(24, dealer.getPoints());
    }
    
}
