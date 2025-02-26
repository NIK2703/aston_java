package ru.aston.ogurnoy_na.patterns.structural.decorator;

// Добавка: Молоко
public class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.5; // +0.5 к стоимости
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", молоко";
    }
}
