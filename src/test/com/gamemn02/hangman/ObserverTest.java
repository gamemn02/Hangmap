package com.gamemn02.hangman;

import org.junit.jupiter.api.Test;

public class ObserverTest {

    @Test
    public void testObserverPattern() {
        // given
        Observable win = new Observable();
        Observable loss = new Observable();
        win.addObserver( gameInfo -> System.out.println("win good!"));
        loss.addObserver( gameInfo -> System.out.println("loss good!"));
        // then
        System.out.println("calling notify");
        win.notify(new GameInfo());
        loss.notify(new GameInfo());
    }
}
