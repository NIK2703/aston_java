package ru.aston.ogurnoy_na.patterns.structural.decorator;

// Добавка: Сахар
public class Sugar extends CoffeeDecorator {
    public Sugar(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 0.2; // +0.2 к стоимости
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", сахар";
    }
}