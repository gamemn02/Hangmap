package com.gamemn02.hangman;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Game {
    private int mMaxAppendage;
    private int mCurAppendage;
    private Map<String, Boolean> mLetters;
    private Observable mWinObserver;
    private Observable mLossObserver;

    public Game(int appendage, Map<String, Boolean> letters) {
        mCurAppendage = appendage;
        mLetters = letters;
        mWinObserver = new Observable();
        mLossObserver = new Observable();
    }

    public void play(char letter) {

    }

    public void observe(Observer winObserver, Observer lossObserver) {

    }

}
