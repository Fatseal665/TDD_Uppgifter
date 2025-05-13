package se.demo.cardgame.cards;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DeckTest {
    @Test
    public void shuffleTest() {
        Deck deck = new Deck();
        Card card = new Card(2, Suit.SPADES);
        deck.shuffle();

        assertNotEquals(card, deck.drawCard());
    }

    @Test
    public void drawCardTest() {
        Deck deck = new Deck();

        assertNotEquals(deck.drawCard(), deck.drawCard());
    }

    @Test
    public void testDeckLength(){
        Deck deck = new Deck();

        assertEquals(52, deck.deckLength());
    }

    @Test
    public void testCreatNewDeck(){
        Deck deck = new Deck();
        deck.clearDeck();

        deck.creatNewDeck();

        assertEquals(52, deck.deckLength());
    }
}
