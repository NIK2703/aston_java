package ru.aston.ogurnoy_na.patterns.behavioural.startegy;

// Стратегия вычитания
public class SubtractStrategy implements Strategy {
    @Override
    public void execute(int a, int b) {
        System.out.println(a + " - " + b + " = " + (a - b));
    }
}