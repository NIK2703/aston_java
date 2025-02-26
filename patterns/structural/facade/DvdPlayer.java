package ru.aston.ogurnoy_na.patterns.structural.facade;

// Класс DVD-плеера
class DvdPlayer {
    public void on() {
        System.out.println("DVD-плеер включен");
    }

    public void play(String movie) {
        System.out.println("Воспроизведение фильма: " + movie);
    }

    public void off() {
        System.out.println("DVD-плеер выключен");
    }
}