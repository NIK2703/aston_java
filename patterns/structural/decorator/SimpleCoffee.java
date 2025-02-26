package ru.aston.ogurnoy_na.patterns.structural.decorator;

public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 2.0; // Базовая стоимость
    }

    @Override
    public String getDescription() {
        return "Простой кофе";
    }
}