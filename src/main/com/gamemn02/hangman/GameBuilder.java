package com.gamemn02.hangman;

import com.gamemn02.hangman.utils.PhraseUtil;

import java.util.ArrayList;

public class GameBuilder {

    protected int mMaxAttempts;
    protected int mCurAttempt;
    protected String mPhrase;

    public GameBuilder withMaxAttempts(int maxAttempts) {
        mMaxAttempts = maxAttempts;
        return this;
    }

    public GameBuilder withCurAttempt(int curAttempt) {
        mCurAttempt = curAttempt;
        return this;
    }

    public GameBuilder withPhrase(String phrase) {
        mPhrase = phrase;
        return this;
    }

    public Game build() {
        ArrayList<GameLetter> letters = PhraseUtil.phraseToLetters(mPhrase);

        if (letters == null) {
            return null;
        }

        return new Game(new StaticGameState(new GameState(mMaxAttempts, mCurAttempt, letters)));
    }
}
