package com.gamemn02.hangman;

import java.util.List;

public class GameState implements Cloneable {
    public static final int NOT_FOUND = -1;
    private int mMaxAttempts;
    private int mCurAttempts;
    private List<GameLetter> mLetters;

    public GameState(int maxAttempts, int curAttempts, List<GameLetter> letters) {
        mMaxAttempts = maxAttempts;
        mCurAttempts = curAttempts;
        mLetters = letters;
    }

    public List<GameLetter> getLetters() {
        return mLetters;
    }

    public int findNotFoundLetter(char letter) {
        GameLetter notFoundGameLetter = new GameLetter(letter, false);
        return mLetters.indexOf(notFoundGameLetter);
    }

    public void setFound(int letterIndex) {
        mLetters.get(letterIndex).setFound();
    }

    public void setCurAttempts(int curAttempts) {
        mCurAttempts = curAttempts;
    }

    public int getMaxAttempts() {
        return mMaxAttempts;
    }

    public int getCurAttempts() {
        return mCurAttempts;
    }

    public boolean doesWin() {
        for (GameLetter l : mLetters) {
            if (!l.isFound() && !Character.isWhitespace(l.getChar())) {
                return false;
            }
        }
        return true;
    }

    public boolean doesLoss() {
        return mCurAttempts >= mMaxAttempts;
    }

    public int getRemainingAttempts() {
        return mMaxAttempts - mCurAttempts;
    }

    @Override
    protected GameState clone() {
        return new GameState(mMaxAttempts, mCurAttempts, mLetters);
    }

}
