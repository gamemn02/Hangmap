package com.gamemn02.hangman;

import java.util.Vector;

public class Observable {

    private Vector<Observer> observers;

    public Observable() {
        observers = new Vector<>();
    }

    public void addObserver(Observer observer) {
        if (observer == null)
            throw new NullPointerException();
        if (!observers.contains(observer)) {
            observers.addElement(observer);
        }
    }

    public void notify(GameInfo gameInfo) {
        Object[] arrLocal = observers.toArray();
        for (int i = arrLocal.length-1; i>=0; i--)
            ((Observer)arrLocal[i]).update(gameInfo);
    }

    public void deleteObserver(Observer observer) {
        observers.removeElement(observer);
    }

    public void deleteObservers() {
        observers.removeAllElements();
    }
}
