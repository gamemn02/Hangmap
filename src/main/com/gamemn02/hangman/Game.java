package com.gamemn02.hangman;

public class Game {
    private GameState mGameState;
    private GameListener mEventGameListener;

    public Game(StaticGameState gameState) {
        mGameState = gameState.asGameState();
    }

    public void play(char letter) {
        int letterIndex = mGameState.findNotFoundLetter(letter);
        if (letterIndex == GameState.NOT_FOUND) { // Fail
            mGameState.setCurAttempts(mGameState.getCurAttempts()+1);
            mEventGameListener.stateChanged(new StaticGameState(mGameState), GameEvent.FAIL);
        } else { // Success
            mGameState.setFound(letterIndex);
            mEventGameListener.stateChanged(new StaticGameState(mGameState), GameEvent.SUCCESS);
        }
    }

    public void setEventListener(GameListener eventGameListener) {
        mEventGameListener = eventGameListener;
    }

}
