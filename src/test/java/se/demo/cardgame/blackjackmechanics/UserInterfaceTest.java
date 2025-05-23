package se.demo.cardgame.blackjackmechanics;
import org.junit.jupiter.api.Test;
import se.demo.cardgame.cards.Card;
import se.demo.cardgame.cards.Deck;
import se.demo.cardgame.cards.Suit;
import se.demo.cardgame.user.Dealer;
import se.demo.cardgame.user.Player;
import se.demo.cardgame.user.User;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class UserInterfaceTest {

    //skipping for now
    @Test
    void testUIHit() {

    }

    @Test
    void testChoiceHit() {
        Card card = new Card(2, Suit.SPADES);
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(card);

        Deck deck = new Deck(hand);
        User user = new Player("Player");

        UserInterface.choiceMade("hit", user, new Dealer());

        assertEquals(card, user.getCard(0));
    }

    @Test
    void testChoiceHitContinue() {
        Card card = new Card(2, Suit.SPADES);
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(card);

        Deck deck = new Deck(hand);
        User user = new Player("Player");

        boolean continued = UserInterface.choiceMade("hit", user, new Dealer());

        assertTrue(continued);
    }

    @Test
    void testChoiceStay() {
        Deck deck = new Deck();
        User user = new Player("Player");

        boolean continued = UserInterface.choiceMade("stay", user, new Dealer());

        assertFalse(continued);
    }

    @Test
    void testChoiceViewHand() {
        Deck deck = new Deck();
        User user = new Player("Player");

        boolean continued = UserInterface.choiceMade("view hand", user, new Dealer());

        assertTrue(continued);
    }



}
