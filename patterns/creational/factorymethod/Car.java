package ru.aston.ogurnoy_na.patterns.creational.factorymethod;

public class Car implements Transport {
    @Override
    public void deliver() {
        System.out.println("Доставка по дороге на автомобиле");
    }
}