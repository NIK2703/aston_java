package ru.aston.ogurnoy_na.patterns.behavioural.chainofresponsibility;

public abstract class AbstractLogger {
    public static int DEBUG = 1;
    public static int WARNING = 2;
    public static int ERROR = 3;

    protected int level;
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void handleRequest(int level, String message) {
        if (this.level == level) {
            write(message);
        } else if (nextLogger != null) {
            nextLogger.handleRequest(level, message);
        }
    }

    abstract protected void write(String message);
}