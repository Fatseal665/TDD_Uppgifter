package se.demo.cardgame.user;

import se.demo.cardgame.cards.Card;

import java.util.ArrayList;

public class User {
    private ArrayList<Card> cards = new ArrayList<>();
    private String name;

    public User(String name) {
        this.name = name;
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

    public int getPoints() {
        int points = 0;
        int numberOfAces = 0;

        for (Card card : cards) {
            if (card.getValue() <= 10) {
                points += card.getValue();
            } else if (card.getValue() <= 13) {
                points += 10;
            } else if (card.getValue() == 14) {
                numberOfAces += 1;
            }
        }
        for (int i = 0; i < numberOfAces; i++) {
            if (points + 11 <= 21) {
                points += 11;
            } else points += 1;
        }

        return points;
    }

    public void printHand(){
        System.out.println(name+"'s hand is: ");

        for (Card card : cards) {
            System.out.println(card);
        }
    }
    
    public String toString(){
        return name;    
    }


}
