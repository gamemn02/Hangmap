package com.gamemn02.hangman;

public class GameLetter {
    private char mLetterChar;
    private boolean mFound;

    public GameLetter(char letterChar) {
        mLetterChar = letterChar;
        mFound = false;
    }

    public GameLetter(char letterChar, boolean found) {
        mLetterChar = letterChar;
        mFound = found;
    }

    public boolean isFound() {
        return mFound;
    }

    public char getChar() {
        return mLetterChar;
    }

    public void setFound() {
        mFound = true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        GameLetter gameLetter;
        try {
            gameLetter = (GameLetter) obj;
        }
        catch (ClassCastException e) {
            return false;
        }

        if (mLetterChar == gameLetter.getChar() && mFound == gameLetter.isFound()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(mLetterChar);
    }
}
