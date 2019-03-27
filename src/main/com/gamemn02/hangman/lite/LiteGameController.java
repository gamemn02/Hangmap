package com.gamemn02.hangman.lite;

import com.gamemn02.hangman.*;

public class LiteGameController implements GameController, GameListener {

    private GameBuilder mGameBuilder;
    private GameView mGameView;
    private Game mGame;
    private boolean mGameOver;

    public LiteGameController(GameBuilder gameBuilder) {
        mGameBuilder = gameBuilder;
    }

    public void setGameView(GameView gameView) {
        mGameView = gameView;
    }

    public void start() {
        mGameView.requestPhrase();
        while (!mGameOver) {
            mGameView.requestAlphabet();
        }
    }

    @Override
    public void onPhraseEntered(String phrase) {
        mGame = mGameBuilder.withPhrase(phrase).build();
        if (mGame != null) {
            mGame.setEventListener(this);
        } else {
            mGameView.showInvalidPhrase();
            mGameView.requestPhrase();
        }
    }

    @Override
    public void onAlphabetEntered(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            mGame.play(c);
        } else {
            mGameView.showInvalidAlphabet();
            mGameView.requestAlphabet();
        }
    }

    @Override
    public void stateChanged(StaticGameState staticGameState, GameEvent gameEvent) {
        if (staticGameState.doesWin()) {
            mGameView.showWin();
            mGameView.showLetters(staticGameState);
            mGameOver = true;
            return;
        } else if (staticGameState.doesLoss()) {
            mGameView.showLoss();
            mGameOver = true;
            return;
        }

        if (gameEvent == GameEvent.SUCCESS) {
            mGameView.showSuccess();
        } else if (gameEvent == GameEvent.FAIL) {
            mGameView.showFail();
            mGameView.showRemainingAttempts(staticGameState.getRemainingAttempts());
        }

        mGameView.showLetters(staticGameState);
    }
}
