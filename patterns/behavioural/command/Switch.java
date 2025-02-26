package ru.aston.ogurnoy_na.patterns.behavioural.command;

public class Switch {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}