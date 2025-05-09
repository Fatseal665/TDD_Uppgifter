package se.demo.cardgame.user;


import org.junit.jupiter.api.Test;
import se.demo.cardgame.cards.Card;
import se.demo.cardgame.cards.Deck;
import se.demo.cardgame.cards.Suit;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayTest {
    @Test
    void testHit() {
        Deck deck = new Deck();
        User user = new User();

        Card card = new Card(2, Suit.SPADES);


        Play.hit(user, deck);

        assertEquals(card, user.getCard(0));
    }


    @Test
    void testDealerUnder21() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(10, Suit.SPADES));
        cards.add(new Card(8, Suit.DIAMONDS));

        Deck deck = new Deck(cards);
        User dealer = new User();

        Play.dealerPlay(dealer, deck);

        assertEquals(18, dealer.getPoints());
    }

    @Test
    void testDealerOver21() {
        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(10, Suit.SPADES));
        cards.add(new Card(6, Suit.DIAMONDS));
        cards.add(new Card(8, Suit.CLUBS));

        Deck deck = new Deck(cards);
        User dealer = new User();

        Play.dealerPlay(dealer, deck);
        assertEquals(24, dealer.getPoints());
    }
}
