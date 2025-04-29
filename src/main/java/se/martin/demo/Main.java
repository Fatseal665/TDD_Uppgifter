package se.martin.demo;

import se.martin.demo.cards.Deck;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome Eric!");
        Deck deck = new Deck();
        deck.shuffle();
        deck.printDeck();
    }
}
