package ru.aston.ogurnoy_na.patterns.behavioural.chainofresponsibility;

public class DebugLogger extends AbstractLogger {
    public DebugLogger() {
        this.level = DEBUG;
    }

    @Override
    protected void write(String message) {
        System.out.println("Debug Logger: " + message);
    }
}