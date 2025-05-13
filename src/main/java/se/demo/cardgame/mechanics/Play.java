package se.demo.cardgame.mechanics;

import se.demo.cardgame.cards.Card;
import se.demo.cardgame.cards.Deck;
import se.demo.cardgame.user.Dealer;
import se.demo.cardgame.user.Player;
import se.demo.cardgame.user.User;

public class Play {

    public static void StartGame(Dealer dealer, Player player) {
        boolean cont;
        do {
            dealStartHand(player,dealer.getDeck());
            dealStartHand(dealer,dealer.getDeck());

            dealer.printHiddenHand();
            player.printHand();

            Play.playerPlay(player, dealer.getDeck());

            dealer.printHand();

            Play.dealerPlay(dealer, dealer.getDeck());

            boolean win = GameLogic.calculateResult(player, dealer);

            if (win) {
                System.out.println(player + " Wins !!!!!!!!!!!!!!!!!!!!!!!");
            } else {
                System.out.println(dealer + " Wins :(");
            }
            dealer.clearHand();
            player.clearHand();
            cont = UserInterface.getContinue();
        }while(cont);
    }

    public static void dealerPlay(User dealer, Deck deck) {
        while (dealer.getPoints() <= 17) {
            UserInterface.pause();
            hit(dealer, deck);
            dealer.printHand();
        }
        GameLogic.printResult(dealer);
    }

    public static void playerPlay(User player, Deck deck) {
        boolean cont;
        do {
            String choice = UserInterface.playerChoice();
            cont = UserInterface.choiceMade(choice, deck, player);
            player.printHand();
        } while (cont && player.getPoints() <= 21);

        GameLogic.printResult(player);
    }

    public static void hit(User user, Deck deck) {
        if(deck.deckLength()>0) {
            Card card = deck.drawCard();
            user.giveCard(card);
        }else {
            System.out.println("deck empty");
            deck.creatNewDeck();
            deck.shuffle();
        }
    }

    public static void dealStartHand(User user, Deck deck) {
        hit(user, deck);
        hit(user, deck);
    }
}
