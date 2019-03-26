package com.gamemn02.hangman.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    public void phraseToLetters() {
        System.out.println(PhraseUtil.phraseToLetters("multiple words"));
    }
}