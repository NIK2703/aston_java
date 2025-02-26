package ru.aston.ogurnoy_na.patterns.behavioural.chainofresponsibility;

public class ErrorLogger extends AbstractLogger {
    public ErrorLogger() {
        this.level = ERROR;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Logger: " + message);
    }
}