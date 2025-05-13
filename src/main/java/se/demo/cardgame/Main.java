package se.demo.cardgame;

import se.demo.cardgame.cards.Deck;
import se.demo.cardgame.user.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");


        String name = UserInterface.getUserName();
        Player player = new Player(name);
        Dealer dealer = new Dealer();


        dealer.dealerShuffle();
        //deal first hand

        dealer.printHand();
        player.printHand();

        Play.playerPlay(player, dealer.getDeck());

        Play.dealerPlay(dealer, dealer.getDeck());

        boolean win = Play.calculateResult(player, dealer);

        if(win){
            System.out.println(player+" Wins !!!!!!!!!!!!!!!!!!!!!!!");
        }else{
            System.out.println(dealer+" Wins :(");
        }
    }
}
