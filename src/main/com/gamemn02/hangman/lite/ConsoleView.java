package com.gamemn02.hangman.lite;

import com.gamemn02.hangman.GameLetter;
import com.gamemn02.hangman.GameView;

import java.util.Scanner;

public class ConsoleView implements GameView {

    private LiteGameController mLiteGameController;
    Scanner scanner = new Scanner(System.in);

    public ConsoleView(LiteGameController liteGameController) {
        mLiteGameController = liteGameController;
        mLiteGameController.setGameView(this);
    }

    @Override
    public void requestPhrase() {
        System.out.print("Enter hangman phrase: ");
        String phrase = scanner.nextLine();
        mLiteGameController.onPhraseEntered(phrase);
    }

    @Override
    public void showInvalidPhrase() {
        System.out.println("invalid phrase. Please use only alphabets and whitespaces.");
    }

    @Override
    public void requestAlphabet() {
        while (true) {
            System.out.println("Guess an alphabet: ");
            String character = scanner.next();
            char c = character.toCharArray()[0];
            if (character.length() == 1) {
                mLiteGameController.onAlphabetEntered(c);
                break;
            } else {
                showInvalidAlphabet();
            }
        }
    }

    @Override
    public void showInvalidAlphabet() {
        System.out.println("please enter only one alphabet.");
    }

    @Override
    public void showSuccess() {
        System.out.println("\tYou get it!");
    }

    @Override
    public void showFail() {
        System.out.println("\tWrong. Guess another!");
    }

    @Override
    public void showRemainingAttempts(int attempts) {
        System.out.println("\t" + attempts + " remaining attempts.");
    }

    @Override
    public void showLetters(Iterable<GameLetter> letters) {
        System.out.print("\t");
        for (GameLetter l : letters) {
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
    }

    @Override
    public void showWin() {
        System.out.println("You win!");
    }

    @Override
    public void showLoss() {
        System.out.println("You Loss!");
    }
}
