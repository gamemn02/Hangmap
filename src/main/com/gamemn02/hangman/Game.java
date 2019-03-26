package com.gamemn02.hangman;

public class Game {
    private GameState mGameState;
    private Observable mWinObservable;
    private Observable mLossObservable;

    public Game(StaticGameState gameState) {
        mGameState = gameState.asGameState();
        mWinObservable = new Observable();
        mLossObservable = new Observable();
    }

    public void play(char letter) {
        int letterIndex = mGameState.findNotFoundLetter(letter);
        if (letterIndex == GameState.NOT_FOUND) { // Loss
            mGameState.setCurAppendage(mGameState.getCurAppendage()+1);
            mLossObservable.notify(new StaticGameState(mGameState));
        } else { // Win
            mGameState.setFound(letterIndex);
            mWinObservable.notify(new StaticGameState(mGameState));

        }
    }

    public void observe(Observer winObserver, Observer lossObserver) {
        mWinObservable.addObserver(winObserver);
        mLossObservable.addObserver(lossObserver);
    }

}
