package ru.aston.ogurnoy_na.patterns.structural.decorator;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println("Кофе: " + coffee.getDescription() + ", стоимость: $" + coffee.getCost());

        coffee = new Milk(coffee); // Добавляем молоко
        coffee = new Sugar(coffee); // Добавляем сахар
        System.out.println("Кофе: " + coffee.getDescription() + ", стоимость: $" + coffee.getCost());
    }
}