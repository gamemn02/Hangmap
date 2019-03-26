package com.gamemn02.hangman;

public interface GameListener {
    public void stateChanged(StaticGameState staticGameState, GameEvent gameEvent);
}
