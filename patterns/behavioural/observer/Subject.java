package ru.aston.ogurnoy_na.patterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}