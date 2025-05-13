package se.demo.cardgame.user;

import se.demo.cardgame.cards.Card;

public class Player extends User{
    private String name;
    public Player(String name) {
        super();
        this.name = name;
    }

    @Override
    public void printHand(){
        System.out.println(name+"'s hand is: ");

        super.printHand();
    }

    @Override
    public String toString() {
        return name;
    }
}
