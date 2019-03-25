package com.gamemn02.hangman;

import java.util.HashMap;

public class GameFactory {
    public static Game createNewGame(int maxAppendage, String phrase) {
        return new Game(maxAppendage, 0, null);
    }
}
