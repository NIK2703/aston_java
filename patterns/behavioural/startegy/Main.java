package ru.aston.ogurnoy_na.patterns.behavioural.startegy;

public class Main {
    public static void main(String[] args) {
        Context context = new Context(new AddStrategy());
        context.executeStrategy(5, 3); // 5 + 3 = 8

        context.setStrategy(new SubtractStrategy());
        context.executeStrategy(5, 3); // 5 - 3 = 2

        context.setStrategy(new MultiplyStrategy());
        context.executeStrategy(5, 3); // 5 * 3 = 15
    }
}