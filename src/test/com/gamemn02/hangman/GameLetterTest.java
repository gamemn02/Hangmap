package com.gamemn02.hangman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLetterTest {

    @Test
    public void equalsWorksPerfectly() {
        // when
        GameLetter gameLetter1 = new GameLetter('e', false);
        GameLetter gameLetter2 = new GameLetter('e', false);
        GameLetter gameLetter3 = new GameLetter('f', false);
        GameLetter gameLetter4 = new GameLetter('e', true);
        GameLetter nullObject = null;
        Object notGameLetter = new Object();
        // then
        assertEquals(gameLetter1, gameLetter2);
        assertNotEquals(gameLetter1, gameLetter3);
        assertNotEquals(gameLetter1, gameLetter4);
        assertNotEquals(gameLetter1, nullObject);
        assertNotEquals(gameLetter1, notGameLetter);
    }

}