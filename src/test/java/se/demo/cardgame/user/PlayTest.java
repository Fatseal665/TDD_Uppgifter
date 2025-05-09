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
        Card card = new Card(2, Suit.SPADES);
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(card);

        Deck deck = new Deck(hand);
        User user = new User();

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
        User dealer = new User();

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
        User dealer = new User();

        Play.dealerPlay(dealer, deck);
        assertEquals(24, dealer.getPoints());
    }
//-----------------------------------------------------------------------------------
    @Test
    void testResultLogicPlayerBustAndDealerBust(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(10, Suit.SPADES));
        hand.add(new Card(11, Suit.SPADES));
        hand.add(new Card(12, Suit.SPADES));

        User player = new User();
        giveCards(hand, player);
        User dealer = new User();
        giveCards(hand, dealer);

        boolean playerWin = Play.calculateResult(player,dealer);

        assertEquals(false, playerWin);

    }

    @Test
    void testResultLogicPlayerWinAndDealerBust(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(10, Suit.SPADES));
        hand.add(new Card(11, Suit.SPADES));


        User player = new User();
        giveCards(hand, player);

        hand.add(new Card(12, Suit.SPADES));

        User dealer = new User();
        giveCards(hand, dealer);

        boolean playerWin = Play.calculateResult(player,dealer);

        assertEquals(true, playerWin);
    }

    @Test
    void testResultLogicPlayerBustAndDealerWin(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(10, Suit.SPADES));
        hand.add(new Card(11, Suit.SPADES));

        User dealer = new User();
        giveCards(hand, dealer);

        hand.add(new Card(12, Suit.SPADES));

        User player = new User();
        giveCards(hand, player);

        boolean playerWin = Play.calculateResult(player,dealer);

        assertEquals(false, playerWin);
    }

    @Test
    void testResultLogicPlayerWinAndDealerNoBust(){
        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(10, Suit.SPADES));
        hand1.add(new Card(11, Suit.SPADES));

        ArrayList<Card> hand2 = new ArrayList<>();
        hand2.add(new Card(10, Suit.HEARTS));
        hand2.add(new Card(7, Suit.HEARTS));

        User player = new User();
        giveCards(hand1, player);
        User dealer = new User();
        giveCards(hand2, dealer);

        boolean playerWin = Play.calculateResult(player,dealer);

        assertEquals(true, playerWin);
    }

    @Test
    void testResultLogicPlayerNoBustAndDealerWin(){
        ArrayList<Card> hand1 = new ArrayList<>();
        hand1.add(new Card(10, Suit.SPADES));
        hand1.add(new Card(7, Suit.SPADES));

        ArrayList<Card> hand2 = new ArrayList<>();
        hand2.add(new Card(10, Suit.HEARTS));
        hand2.add(new Card(11, Suit.HEARTS));

        User player = new User();
        giveCards(hand1, player);
        User dealer = new User();
        giveCards(hand2, dealer);

        boolean playerWin = Play.calculateResult(player,dealer);

        assertEquals(false , playerWin);
    }

    @Test
    void testResultLogicTie(){ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(10, Suit.SPADES));
        hand.add(new Card(11, Suit.SPADES));

        User player = new User();
        giveCards(hand, player);
        User dealer = new User();
        giveCards(hand, dealer);

        boolean playerWin = Play.calculateResult(player,dealer);

        assertEquals(false, playerWin);}


    public static User giveCards(ArrayList<Card> cards,User user) {
        for (Card card : cards) {
            user.giveCard(card);
        }
    }
}
