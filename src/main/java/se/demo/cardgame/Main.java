package se.demo.cardgame;

import se.demo.cardgame.cards.Deck;
import se.demo.cardgame.user.UserInterface;
import se.demo.cardgame.user.Play;
import se.demo.cardgame.user.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Blackjack!");

        Deck deck = new Deck();
        deck.shuffle();
        String name = UserInterface.getUserName();
        User player = new User(name);
        User dealer = new User("Dealer");

        //deal first hand

        dealer.printHand();
        player.printHand();

        Play.playerPlay(player,deck);

        Play.dealerPlay(dealer, deck);

        boolean win = Play.calculateResult(player, dealer);

        if(win){
            System.out.println(player+" Wins !!!!!!!!!!!!!!!!!!!!!!!");
        }else{
            System.out.println(dealer+" Wins :(");
        }
    }
}
