package ru.aston.ogurnoy_na.patterns.behavioural.observer;

public class NewsChannel implements Observer {
    private String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("[" + name + "] Получена новость: " + message);
    }
}