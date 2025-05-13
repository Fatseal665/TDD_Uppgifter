package se.demo.cardgame.mechanics;

import se.demo.cardgame.user.User;

public class GameLogic {
    static void printResult(User user) {
        if (user.getPoints() > 21) {
            System.out.println(user + " went bust with " + user.getPoints() + " points");
        } else if (user.getPoints() == 21) {
            System.out.println(user + " got blackjack");
        } else {
            System.out.println(user + " ended with " + user.getPoints() + " points");
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
