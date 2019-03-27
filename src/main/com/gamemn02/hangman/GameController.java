package com.gamemn02.hangman;

public interface GameController {
    public abstract void onPhraseEntered(String phrase);

    public abstract void onAlphabetEntered(char a);
}
