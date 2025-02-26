package ru.aston.ogurnoy_na.patterns.creational.singleton;

public enum EnumSingleton {
    INSTANCE;

    public void doSomething() {
        System.out.println("Выполнение действия...");
    }
}