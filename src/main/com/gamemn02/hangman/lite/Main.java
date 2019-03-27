package com.gamemn02.hangman.lite;

public class Main {

    public static void main(String[] args) {
        LiteGameBuilder liteGameBuilder = new LiteGameBuilder();
        LiteGameController liteGameController = new LiteGameController(liteGameBuilder);
        ConsoleView consoleView = new ConsoleView(liteGameController);
        liteGameController.start();
    }
}
