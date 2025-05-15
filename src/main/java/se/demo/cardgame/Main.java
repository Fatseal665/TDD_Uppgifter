package se.demo.cardgame;

import se.demo.cardgame.mechanics.Play;
import se.demo.cardgame.mechanics.UserInterface;
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
