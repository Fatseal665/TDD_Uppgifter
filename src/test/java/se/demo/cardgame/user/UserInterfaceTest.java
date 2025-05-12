package se.demo.cardgame.user;
import org.junit.jupiter.api.Test;
import se.demo.cardgame.cards.Card;
import se.demo.cardgame.cards.Deck;
import se.demo.cardgame.cards.Suit;

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
        User user = new User("Player");

        UserInterface.choiceMade("hit", deck, user);

        assertEquals(card, user.getCard(0));
    }

    @Test
    void testChoiceHitContinue() {
        Card card = new Card(2, Suit.SPADES);
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(card);

        Deck deck = new Deck(hand);
        User user = new User("Player");

        boolean continued = UserInterface.choiceMade("hit", deck, user);

        assertTrue(continued);
    }

    @Test
    void testChoiceStay() {
        Deck deck = new Deck();
        User user = new User("Player");

        boolean continued = UserInterface.choiceMade("stay", deck, user);

        assertFalse(continued);
    }

    @Test
    void testChoiceViewHand() {
        Deck deck = new Deck();
        User user = new User("Player");

        boolean continued = UserInterface.choiceMade("view hand", deck, user);

        assertTrue(continued);
    }



}
