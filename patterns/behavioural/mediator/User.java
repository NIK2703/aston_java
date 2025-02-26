package ru.aston.ogurnoy_na.patterns.behavioural.mediator;

public class User extends Colleague {
    public User(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(name + " отправляет: " + message);
        mediator.sendMessage(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(name + " получил: " + message);
    }
}