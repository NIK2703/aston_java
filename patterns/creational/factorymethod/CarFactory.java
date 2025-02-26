package ru.aston.ogurnoy_na.patterns.creational.factorymethod;

public class CarFactory extends TransportFactory {
    @Override
    public Transport createTransport() {
        return new Car();
    }
}