package com.gamemn02.hangman;

import java.util.Scanner;

public class GameConsoleProgram {

    private static boolean win = false;
    private static boolean loss = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = null;
        while (game == null) {
            System.out.println("Player1 enter the game phrase: ");
            String phrase = scanner.nextLine();
            game = GameFactory.createNewGame(4, phrase);
            if (game == null) {
                System.out.println("invalid phrase. Please use only alphabets and whitespaces.");
            }
        }

        game.setEventListener(((staticGameState, gameEvent) -> {
            if (gameEvent == GameEvent.SUCCESS) {
                System.out.println("you get it! : ");
            } else if(gameEvent == GameEvent.FAIL) {
                System.out.println("wrong try again!. " + staticGameState.getRemainingAttempts() + " remaining attempts.");
            }
            System.out.print("\t");
            for (GameLetter l : staticGameState) {
                char c = l.getChar();
                if (Character.isWhitespace(c)) {
                    System.out.print("  ");
                } else if (l.isFound()) {
                    System.out.print(String.valueOf(c) + ' ');
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.print("\n");

            if (staticGameState.doesWin()) {
                win = true;
            } else if (staticGameState.doesLoss()) {
                loss = true;
            }
        }));

        while(true) {
            if (win) {
                System.out.println("Player2 win");
                break;
            } else if (loss) {
                System.out.println("Player1 win");
                break;
            }
            System.out.println("Player2 guess an alphabet: ");
            String character = scanner.next();
            char c = character.toCharArray()[0];
            if (character.length() == 1 && ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))) {
                game.play(c);
            } else {
                System.out.println("please enter only one alphabet.");
            }
        }
    }
}
