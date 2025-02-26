package ru.aston.ogurnoy_na.patterns.behavioural.chainofresponsibility;

public class WarningLogger extends AbstractLogger {
    public WarningLogger() {
        this.level = WARNING;
    }

    @Override
    protected void write(String message) {
        System.out.println("Warning Logger: " + message);
    }
}