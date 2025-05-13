package se.demo.cardgame.mechanics;

import se.demo.cardgame.cards.Card;
import se.demo.cardgame.cards.Deck;
import se.demo.cardgame.user.User;

public class Play {

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
        Card card = deck.drawCard();
        user.giveCard(card);
    }
}
