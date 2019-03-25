package com.gamemn02.hangman;

import java.util.HashMap;

public class GameFactory {
    public static Game createNewGame(int appendage, String phrase) {
        return new Game(appendage, new HashMap<String, Boolean>());
    }
}
