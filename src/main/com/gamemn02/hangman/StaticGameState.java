package com.gamemn02.hangman;

import java.util.Iterator;

public class StaticGameState implements Iterable<GameLetter> {
    public GameState mGameState;

    public StaticGameState(GameState gameState) {
        mGameState = gameState.clone();
    }

    public GameState asGameState() {
        return mGameState;
    }

    public boolean doesWin() {
        return mGameState.doesWin();
    }

    public boolean doesLoss() {
        return mGameState.doesLoss();
    }

    public int getRemainingAttempts() {
        return mGameState.getRemainingAttempts();
    }

    @Override
    public Iterator<GameLetter> iterator() {
        return mGameState.getLetters().iterator();
    }
}
