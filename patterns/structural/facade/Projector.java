package ru.aston.ogurnoy_na.patterns.structural.facade;


// Класс проектора
class Projector {
    public void down() {
        System.out.println("Экран проектора опущен");
    }

    public void on() {
        System.out.println("Проектор включен");
    }

    public void off() {
        System.out.println("Проектор выключен");
    }
}