package ru.aston.ogurnoy_na.patterns.behavioural.command;


// Команда выключения света
public class TurnOffLightCommand implements Command {
    private Light light;

    public TurnOffLightCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}