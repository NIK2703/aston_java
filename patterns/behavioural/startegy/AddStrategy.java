package ru.aston.ogurnoy_na.patterns.behavioural.startegy;

// Стратегия сложения
public class AddStrategy implements Strategy {
    @Override
    public void execute(int a, int b) {
        System.out.println(a + " + " + b + " = " + (a + b));
    }
}