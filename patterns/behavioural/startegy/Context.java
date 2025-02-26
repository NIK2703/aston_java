package ru.aston.ogurnoy_na.patterns.behavioural.startegy;

public class Context {
    private Strategy strategy;

    // Установка стратегии через конструктор
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    // Метод для изменения стратегии "на лету"
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    // Выполнение текущей стратегии
    public void executeStrategy(int a, int b) {
        strategy.execute(a, b);
    }
}