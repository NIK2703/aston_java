package ru.aston.ogurnoy_na.patterns.creational.singleton;

public class Client {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.doSomething(); // Выполнение действия...

        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        enumSingleton.doSomething(); // Выполнение действия...
    }
}