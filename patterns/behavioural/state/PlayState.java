package ru.aston.ogurnoy_na.patterns.behavioural.state;

public class PlayState implements State {
    @Override
    public void play() {
        System.out.println("Уже воспроизводится...");
    }

    @Override
    public void pause() {
        System.out.println("Пауза ▶️⏸️");
    }

    @Override
    public void stop() {
        System.out.println("Остановка ⏸️⏹️");
    }
}