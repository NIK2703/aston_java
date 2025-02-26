package ru.aston.ogurnoy_na.patterns.behavioural.mediator;

public interface Mediator {
    void sendMessage(String message, Colleague colleague);
    void addColleague(Colleague colleague);
}