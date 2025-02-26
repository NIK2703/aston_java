package ru.aston.ogurnoy_na.patterns.creational.factorymethod;

public class Client {
    public static void main(String[] args) {
        TransportFactory factory = new CarFactory();
        factory.planDelivery();
        // Вывод:
        // Планирование доставки...
        // Доставка по дороге на автомобиле

        factory = new ShipFactory();
        factory.planDelivery();
        // Вывод:
        // Планирование доставки...
        // Доставка по морю на корабле
    }
}