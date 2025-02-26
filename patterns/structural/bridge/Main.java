package ru.aston.ogurnoy_na.patterns.structural.bridge;

public class Main {
    public static void main(String[] args) {
        // Создаем устройства
        Device tv = new Tv();
        Device radio = new Radio();

        // Пульты для управления устройствами
        RemoteControl basicRemote = new RemoteControl(tv);
        AdvancedRemoteControl advancedRemote = new AdvancedRemoteControl(radio);

        // Управление телевизором
        basicRemote.togglePower();  // Телевизор включен
        basicRemote.volumeUp();     // Громкость: 60%

        // Управление радио
        advancedRemote.togglePower(); // Радио включено
        advancedRemote.mute();       // Громкость: 0%
    }
}