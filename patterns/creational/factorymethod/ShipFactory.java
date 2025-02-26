package ru.aston.ogurnoy_na.patterns.creational.factorymethod;

public class ShipFactory extends TransportFactory {
    @Override
    public Transport createTransport() {
        return new Ship();
    }
}