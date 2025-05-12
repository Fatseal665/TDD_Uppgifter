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
        if (dealer.getPoints() > 21) {
            System.out.println("Dealar went bust with " + dealer.getPoints() + " points");
        } else if (dealer.getPoints() == 21) {
            System.out.println("Dealar got blackjack");
        } else {
            System.out.println("Dealer ended with " + dealer.getPoints() + " points");
        }
    }

    public static boolean calculateResult(User player, User dealer) {
        int playerPoints = player.getPoints();
        int dealerPoints = dealer.getPoints();
        Boolean result = false;
        if (playerPoints > dealerPoints && playerPoints <= 21) {
            result = true;
        }else if (playerPoints <= 21&& dealerPoints > 21) {
            result = true;
        }
        
        return result;
    }
}
