package com.gamemn02.hangman;

import java.util.HashMap;

public class GameFactory {
    public static Game createNewGame(int maxAppendage, String phrase) {
        return new Game(new StaticGameState(new GameState(0, 0, null)));
    }
}
