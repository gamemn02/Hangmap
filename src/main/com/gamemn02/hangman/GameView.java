package com.gamemn02.hangman;

import java.util.List;

public interface GameView {
    public abstract void requestPhrase();

    public abstract void showInvalidPhrase();

    public abstract void requestAlphabet();

    public abstract void showInvalidAlphabet();

    public abstract void showSuccess();

    public abstract void showFail();

    public abstract void showLetters(Iterable<GameLetter> letters);

    public abstract void showRemainingAttempts(int attempts);

    public abstract void showWin();

    public abstract void showLoss();
}
