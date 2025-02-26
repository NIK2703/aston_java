package ru.aston.ogurnoy_na.patterns.behavioural.state;

public class StopState implements State {
    @Override
    public void play() {
        System.out.println("Начинаем воспроизведение ▶️");
    }

    @Override
    public void pause() {
        System.out.println("Невозможно поставить на паузу — трек остановлен!");
    }

    @Override
    public void stop() {
        System.out.println("Уже остановлен!");
    }
}