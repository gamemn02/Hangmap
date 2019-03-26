package com.gamemn02.hangman.utils;

import com.gamemn02.hangman.GameLetter;

import java.util.ArrayList;

public class PhraseUtil {

    public static ArrayList<GameLetter> phraseToLetters(String phrase) {
        ArrayList<GameLetter> letters = new ArrayList<>();
        for (char c : phrase.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || Character.isWhitespace(c)) {
                letters.add(new GameLetter(c));
            } else {
                return null;
            }
        }
        return letters;
    }
}
