package ru.aston.ogurnoy_na.patterns.behavioural.command;

public class Client {
    public static void main(String[] args) {
        Light light = new Light();
        Command turnOn = new TurnOnLightCommand(light);
        Command turnOff = new TurnOffLightCommand(light);

        Switch switcher = new Switch();
        switcher.setCommand(turnOn);
        switcher.executeCommand(); // Свет включен

        switcher.setCommand(turnOff);
        switcher.executeCommand(); // Свет выключен
    }
}