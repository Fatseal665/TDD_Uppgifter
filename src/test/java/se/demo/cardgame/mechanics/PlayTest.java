package se.demo.cardgame.mechanics;


import org.junit.jupiter.api.Test;
import se.demo.cardgame.cards.Card;
import se.demo.cardgame.cards.Deck;
import se.demo.cardgame.cards.Suit;
import se.demo.cardgame.user.Dealer;
import se.demo.cardgame.user.Player;
import se.demo.cardgame.user.User;

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
        Dealer dealer = new Dealer();

        Play.dealerPlay(dealer);

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
        Dealer dealer = new Dealer();

        Play.dealerPlay(dealer);
        assertEquals(24, dealer.getPoints());
    }

    @Test
    void testDealStartHand() {
        Card card1 = new Card(2, Suit.SPADES);
        Card card2 = new Card(3, Suit.SPADES);
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(card1);
        hand.add(card2);

        Deck deck = new Deck(hand);
        User user = new Player("Player");

        Play.dealStartHand(user, deck);

        assertEquals(card2, user.getCard(1));
    }
    
}
