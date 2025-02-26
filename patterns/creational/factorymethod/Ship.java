package ru.aston.ogurnoy_na.patterns.creational.factorymethod;

public class Ship implements Transport {
    @Override
    public void deliver() {
        System.out.println("Доставка по морю на корабле");
    }
}