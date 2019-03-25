package com.gamemn02.hangman;


import java.util.Iterator;

public class Game {
    private int mAppendage;
    private Observable mWinObserver;
    private Observable mLossObserver;

    public Game(int appendage) {
        mAppendage = appendage;
        mWinObserver = new Observable();
        mLossObserver = new Observable();
    }

    public boolean setPhrase(String phrase) {
        return false;
    }

    public void play(char letter) {

    }

    public void observe(Observer winObserver, Observer lossObserver) {

    }

}
