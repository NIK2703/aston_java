package ru.aston.ogurnoy_na.patterns.structural.facade;

// Класс экрана
class Screen {
    public void down() {
        System.out.println("Экран опущен");
    }

    public void up() {
        System.out.println("Экран поднят");
    }
}
