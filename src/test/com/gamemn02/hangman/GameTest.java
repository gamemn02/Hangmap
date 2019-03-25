package com.gamemn02.hangman;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    boolean win = false;
    boolean loss = false;

    @Test
    public void apiWorksSuccessful() {

        HashMap<Character, Boolean> word = new HashMap<>();
        word.put('w', false);
        word.put('o', false);
        word.put('r', false);
        word.put('d', false);
        Game game = new Game(4, 0, word);
        game.observe(gameInfo -> win = true, gameInfo -> loss = true);
        //then
        game.play('o');
        Assertions.assertTrue(win);
        game.play('f');
        Assertions.assertTrue(loss);
    }
}