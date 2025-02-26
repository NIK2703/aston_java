package ru.aston.ogurnoy_na.patterns.behavioural.state;

public class PlayerContext {
    private State state;

    public PlayerContext() {
        this.state = new StopState(); // Начальное состояние
    }

    public void setState(State state) {
        this.state = state;
    }

    public void play() {
        state.play();
    }

    public void pause() {
        state.pause();
    }

    public void stop() {
        state.stop();
    }
}