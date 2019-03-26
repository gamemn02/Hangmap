package com.gamemn02.hangman;

import org.junit.jupiter.api.Test;

public class ObserverTest {

    @Test
    public void testObserverPattern() {
        // given
        Observable win = new Observable();
        Observable loss = new Observable();
        win.addObserver(staticGameState -> System.out.println("win good!"));
        loss.addObserver(staticGameState -> System.out.println("loss good!"));
        // then
        System.out.println("calling notify");
        win.notify(new StaticGameState(new GameState(4, 0, null)));
        loss.notify(new StaticGameState(new GameState(4, 0, null)));
    }
}
