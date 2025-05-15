package se.demo.cardgame;

import se.demo.cardgame.blackjackmechanics.Play;
import se.demo.cardgame.blackjackmechanics.UserInterface;
import se.demo.cardgame.cards.Card;
import se.demo.cardgame.cards.Suit;
import se.demo.cardgame.user.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");

        String name = UserInterface.getUserName();
        Player player = new Player(name);
        Dealer dealer = new Dealer();

        dealer.dealerShuffle();

        Play.startGame(dealer,player);
    }
}
