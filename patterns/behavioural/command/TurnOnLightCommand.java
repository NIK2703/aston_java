package ru.aston.ogurnoy_na.patterns.behavioural.command;

// Команда включения света
public class TurnOnLightCommand implements Command {
    private Light light;

    public TurnOnLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
