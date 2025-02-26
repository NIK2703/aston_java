package ru.aston.ogurnoy_na.patterns.creational.builder;

public class Main {
    public static void main(String[] args) {
        // Создание пиццы через Builder
        Pizza pizza = new Pizza.Builder("Large")
                .addCheese()
                .addPepperoni()
                .addMushrooms()
                .build();

        System.out.println("Size: " + pizza.getSize());
        System.out.println("Cheese: " + pizza.hasCheese());
        System.out.println("Pepperoni: " + pizza.hasPepperoni());
        System.out.println("Mushrooms: " + pizza.hasMushrooms());
    }
}