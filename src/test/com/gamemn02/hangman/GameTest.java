package com.gamemn02.hangman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    boolean win = false;
    boolean loss = false;

    @Test
    public void apiWorksSuccessful() {

        // given
        List<GameLetter> word = new ArrayList<GameLetter>();
        word.add(new GameLetter('w'));
        word.add(new GameLetter('o'));
        word.add(new GameLetter('r'));
        word.add(new GameLetter('d'));
        Game game = new Game(new StaticGameState(new GameState(4, 0, word)));
        // when
        game.observe(gameInfo -> win = true, gameInfo -> loss = true);
        //then
        game.play('o');
        assertTrue(win);
        game.play('f');
        assertTrue(loss);
    }
}