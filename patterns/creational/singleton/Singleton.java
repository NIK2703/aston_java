package ru.aston.ogurnoy_na.patterns.creational.singleton;

public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
        // Защита от рефлексии
        if (instance != null) {
            throw new IllegalStateException("Экземпляр уже создан");
        }
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Действие выполнено");
    }
}