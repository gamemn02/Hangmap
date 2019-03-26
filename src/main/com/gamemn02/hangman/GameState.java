package com.gamemn02.hangman;

import java.util.List;

public class GameState implements Cloneable {
    public static final int NOT_FOUND = -1;
    private int mMaxAppendage;
    private int mCurAppendage;
    private List<GameLetter> mLetters;

    public GameState(int maxAppendage, int curAppendage, List<GameLetter> letters) {
        maxAppendage = mMaxAppendage;
        curAppendage = mCurAppendage;
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

    public void setCurAppendage(int curAppendage) {
        mCurAppendage = curAppendage;
    }

    public int getMaxAppendage() {
        return mMaxAppendage;
    }

    public int getCurAppendage() {
        return mCurAppendage;
    }

    @Override
    protected GameState clone() {
        return new GameState(mMaxAppendage, mCurAppendage, mLetters);
    }
}
