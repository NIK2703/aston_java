package ru.aston.ogurnoy_na.patterns.behavioural.chainofresponsibility;

public class ChainPatternDemo {
    public static void main(String[] args) {
        AbstractLogger debugLogger = new DebugLogger();
        AbstractLogger warningLogger = new WarningLogger();
        AbstractLogger errorLogger = new ErrorLogger();

        // Настройка цепочки
        debugLogger.setNextLogger(warningLogger);
        warningLogger.setNextLogger(errorLogger);

        // Отправка запросов
        debugLogger.handleRequest(AbstractLogger.DEBUG, "Это сообщение уровня DEBUG");
        debugLogger.handleRequest(AbstractLogger.WARNING, "Это сообщение уровня WARNING");
        debugLogger.handleRequest(AbstractLogger.ERROR, "Это сообщение уровня ERROR");
    }
}