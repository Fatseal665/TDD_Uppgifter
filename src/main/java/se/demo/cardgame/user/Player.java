package se.demo.cardgame.user;

import se.demo.cardgame.mechanics.UserInterface;

public class Player extends User{
    private String name;
    public Player(String name) {
        super();
        this.name = name;
    }

    @Override
    public void printHand(){
        System.out.println("\n"+name+"'s hand is: ");
        super.printHand();
        UserInterface.pause();
    }

    @Override
    public String toString() {
        return name;
    }
}
