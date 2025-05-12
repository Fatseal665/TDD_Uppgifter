package se.demo.cardgame.user;

import se.demo.cardgame.cards.Deck;

import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }

    public static String playerChoice(){
        boolean validChoice;
        String choice;

        do {
            System.out.println("Hit \nStay \nView hand");
            System.out.print("Enter Your Choice: ");
            choice = scanner.nextLine().toLowerCase();

            switch (choice) {
                    case "view hand" , "view" , "stay", "hit": validChoice = true; break;
                default:
                    validChoice = false;
                    System.out.println("Invalid choice\n");
                break;
            }
        } while (!validChoice);
        return choice;
    }

    public static boolean choiceMade(String choice, Deck deck, User user) {
        return switch (choice) {
            case "hit" -> {
                Play.hit(user, deck);
                yield true;
            }
            case "stay" -> false;
            case "view hand", "view" -> {
                user.printHand();
                yield true;
            }
            default -> true;
        };
    }
}
