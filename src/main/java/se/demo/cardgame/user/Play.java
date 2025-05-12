package se.demo.cardgame.user;

import se.demo.cardgame.cards.Card;
import se.demo.cardgame.cards.Deck;

public class Play {
    public static void hit(User user, Deck deck) {
        Card card = deck.drawCard();
        user.giveCard(card);
    }

    public static void dealerPlay(User dealer, Deck deck) {
        while (dealer.getPoints() <= 17) {
            hit(dealer, deck);
            dealer.printHand();
        }
        printResult(dealer);
    }

    public static void playerPlay(User player, Deck deck) {
        boolean cont;
        do {
            player.printHand();
            String choice = UserInterface.playerChoice();
            cont = UserInterface.choiceMade(choice, deck, player);
        } while (cont && player.getPoints() <= 21);

        printResult(player);

    }
    
    private static void printResult(User user){
        if (user.getPoints() > 21) {
                    System.out.println(user+" went bust with " + user.getPoints() + " points");
                } else if (user.getPoints() == 21) {
                    System.out.println(user+" got blackjack");
                } else {
                    System.out.println(user+" ended with " + user.getPoints() + " points");
                }
    }

    public static boolean calculateResult(User player, User dealer) {
        int playerPoints = player.getPoints();
        int dealerPoints = dealer.getPoints();
        boolean result = false;
        if (playerPoints > dealerPoints && playerPoints <= 21) {
            result = true;
        } else if (playerPoints <= 21 && dealerPoints > 21) {
            result = true;
        }
        return result;
    }
}
