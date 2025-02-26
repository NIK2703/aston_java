package ru.aston.ogurnoy_na.patterns.structural.facade;

// Класс усилителя
class Amplifier {
    public void on() {
        System.out.println("Усилитель включен");
    }

    public void setVolume(int level) {
        System.out.println("Громкость установлена на " + level + "%");
    }

    public void off() {
        System.out.println("Усилитель выключен");
    }
}
