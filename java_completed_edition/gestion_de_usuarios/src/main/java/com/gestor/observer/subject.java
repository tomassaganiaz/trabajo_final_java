package com.gestor.observer;

import com.gestor.model.User;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(User user, String evento) {
        for (Observer observer : observers) {
            observer.update(user, evento);
        }
    }
}
