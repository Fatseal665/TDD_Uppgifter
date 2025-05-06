package se.demo.cardgame.user;

import se.demo.cardgame.cards.Card;

import java.util.ArrayList;

public class User {
    public User() {


    }

    public void giveCard(Card card) {
        cards.add(card);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public Card getCard(int cardId) {
        return cards.get(cardId);
    }






    ArrayList<Card> cards = new ArrayList<>();

}
