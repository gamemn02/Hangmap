package com.gamemn02.hangman.lite;

import com.gamemn02.hangman.GameBuilder;

public class LiteGameBuilder extends GameBuilder {

    private static final int MAX_ATTEMPTS = 4;

    public LiteGameBuilder() {
        mMaxAttempts = MAX_ATTEMPTS;
        mCurAttempt = 0;
    }
}
