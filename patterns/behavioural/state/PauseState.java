package ru.aston.ogurnoy_na.patterns.behavioural.state;

public class PauseState implements State {
    @Override
    public void play() {
        System.out.println("Продолжаем воспроизведение ⏯️▶️");
    }

    @Override
    public void pause() {
        System.out.println("Уже на паузе!");
    }

    @Override
    public void stop() {
        System.out.println("Остановка ⏸️⏹️");
    }
}