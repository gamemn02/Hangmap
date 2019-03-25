package com.gamemn02.hangman;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Game {
    private int mMaxAppendage;
    private int mCurAppendage;
    private Map<Character, Boolean> mLetters;
    private Observable mWinObservable;
    private Observable mLossObservable;

    public Game(int maxAppendage, int curAppendage, Map<Character, Boolean> letters) {
        mMaxAppendage = maxAppendage;
        mCurAppendage = curAppendage;
        mLetters = letters;
        mWinObservable = new Observable();
        mLossObservable = new Observable();
    }

    public void play(char letter) {
        if (mLetters.containsKey(letter)) {
            mLetters.put(letter, true);
            mWinObservable.notify(new GameInfo());
        } else {
            mCurAppendage++;
            mLossObservable.notify(new GameInfo());
        }
    }

    public void observe(Observer winObserver, Observer lossObserver) {
        mWinObservable.addObserver(winObserver);
        mLossObservable.addObserver(lossObserver);
    }

}
