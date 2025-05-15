package se.demo.cardgame.user;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import se.demo.cardgame.cards.Card;
import se.demo.cardgame.cards.Suit;

import java.util.ArrayList;

public class UserTest {
    @Test
    void testIfPlayerCanKeepCards() {
        User user = new Player("Player");
        Card card = new Card(7, Suit.SPADES);

        user.giveCard(card);
        assertEquals(card, user.getCard(0));
    }

    @Test
    void testIfPlayerCanKeepSeveralCards() {
        User user = new Player("Player");
        Card card1 = new Card(7, Suit.SPADES);
        Card card2 = new Card(14, Suit.HEARTS);

        user.giveCard(card1);
        user.giveCard(card2);

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);

        assertEquals(cards, user.getCards());
    }


    @Test
    void testIfPlayerCanCalculatePointsWhitOneCard(){
        User user = new Player("Player");
        Card card1 = new Card(7, Suit.SPADES);

        user.giveCard(card1);

        assertEquals(7, user.getPoints());
    }
    @Test
    void testIfPlayerCanCalculateThePointsInTheirHand(){
        User user = new Player("Player");
        Card card1 = new Card(7, Suit.SPADES);
        Card card2 = new Card(10, Suit.HEARTS);

        user.giveCard(card1);
        user.giveCard(card2);

        assertEquals(17, user.getPoints());
    }
    @Test
    void testIfPlayerCanCalculateThePointsInTheirHandWhitAAceUnder(){
        User user = new Player("Player");
        Card card1 = new Card(9, Suit.SPADES);
        Card card2 = new Card(14, Suit.HEARTS);

        user.giveCard(card1);
        user.giveCard(card2);

        assertEquals(20, user.getPoints());
    }
    @Test
    void testIfPlayerCanCalculateThePointsInTheirHandWhitAAceOver(){
        User user = new Player("Player");
        Card card1 = new Card(10, Suit.SPADES);
        Card card2 = new Card(14, Suit.HEARTS);
        Card card3 = new Card(5, Suit.CLUBS);

        user.giveCard(card1);
        user.giveCard(card2);
        user.giveCard(card3);

        assertEquals(16, user.getPoints());
    }
    @Test
    void testIfPlayerCanCalculateThePointsInTheirHandWhitTwoAces(){
        User user = new Player("Player");
        Card card1 = new Card(14, Suit.SPADES);
        Card card2 = new Card(14, Suit.HEARTS);
        Card card3 = new Card(11, Suit.CLUBS);

        user.giveCard(card1);
        user.giveCard(card2);
        user.giveCard(card3);

        assertEquals(12, user.getPoints());
    }

    @Test
    void printHandTest() {
        User user = new Player("Player");
        Card card1 = new Card(7, Suit.SPADES);
        Card card2 = new Card(12, Suit.HEARTS);

        user.giveCard(card1);
        user.giveCard(card2);

        user.printHand();                           //most to fast test printHande
        assertNotNull(user.getCards().get(1));

    }
}
