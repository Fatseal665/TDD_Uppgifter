package se.demo.cardgame.blackjackmechanics;

import org.junit.jupiter.api.Test;
import se.demo.cardgame.cards.Card;
import se.demo.cardgame.cards.Suit;
import se.demo.cardgame.user.Dealer;
import se.demo.cardgame.user.Player;
import se.demo.cardgame.user.User;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameLogicTest {
    @Test
    void testResultLogicPlayerBustAndDealerBust(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(10, Suit.SPADES));
        hand.add(new Card(11, Suit.SPADES));
        hand.add(new Card(12, Suit.SPADES));

        User player = new Player("Player");
        giveCards(hand, player);
        User dealer = new Dealer();
        giveCards(hand, dealer);

        boolean playerWin = GameLogic.calculateResult(player,dealer);

        assertEquals(false, playerWin);

    }

    @Test
    void testResultLogicPlayerWinAndDealerBust(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(10, Suit.SPADES));
        hand.add(new Card(11, Suit.SPADES));


        User player = new Player("Player");
        giveCards(hand, player);

        hand.add(new Card(12, Suit.SPADES));

        User dealer = new Dealer();
        giveCards(hand, dealer);

        boolean playerWin = GameLogic.calculateResult(player,dealer);

        assertEquals(true, playerWin);
    }

    @Test
    void testResultLogicPlayerBustAndDealerWin(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(10, Suit.SPADES));
        hand.add(new Card(11, Suit.SPADES));

        User dealer = new Dealer();
        giveCards(hand, dealer);

        hand.add(new Card(12, Suit.SPADES));

        User player = new Player("Player");
        giveCards(hand, player);

        boolean playerWin = GameLogic.calculateResult(player,dealer);

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

        User player = new Player("Player");
        giveCards(hand1, player);
        User dealer = new Dealer();
        giveCards(hand2, dealer);

        boolean playerWin = GameLogic.calculateResult(player,dealer);

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

        User player = new Player("Player");
        giveCards(hand1, player);
        User dealer = new Dealer();
        giveCards(hand2, dealer);

        boolean playerWin = GameLogic.calculateResult(player,dealer);

        assertEquals(false , playerWin);
    }

    @Test
    void testResultLogicTie(){
        ArrayList<Card> hand = new ArrayList<>();
        hand.add(new Card(10, Suit.SPADES));
        hand.add(new Card(11, Suit.SPADES));

        User player = new Player("Player");
        giveCards(hand, player);
        User dealer = new Dealer();
        giveCards(hand, dealer);

        boolean playerWin = GameLogic.calculateResult(player,dealer);

        assertEquals(false, playerWin);
    }


    public static void giveCards(ArrayList<Card> cards,User user) {
        for (Card card : cards) {
            user.giveCard(card);
        }
    }

}
