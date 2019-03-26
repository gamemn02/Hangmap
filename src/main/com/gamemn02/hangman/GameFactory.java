package com.gamemn02.hangman;

import com.gamemn02.hangman.utils.PhraseUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class GameFactory {
    public static Game createNewGame(int maxAppendage, String phrase) {
        ArrayList<GameLetter> letters = PhraseUtil.phraseToLetters(phrase);

        if (letters == null) {
            return null;
        }

        return new Game(new StaticGameState(new GameState(maxAppendage, 0, letters)));
    }
}
