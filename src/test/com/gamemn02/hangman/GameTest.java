package com.gamemn02.hangman;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    boolean success = false;
    boolean fail = false;

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
        game.setEventListener(((staticGameState, gameEvent) -> {
            if (gameEvent == GameEvent.SUCCESS) {
                success = true;
            } else if (gameEvent == GameEvent.FAIL) {
                fail = true;
            }
        }));
        //then
        game.play('o');
        assertTrue(success);
        game.play('f');
        assertTrue(fail);
    }
}