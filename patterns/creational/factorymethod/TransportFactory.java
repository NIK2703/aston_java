package ru.aston.ogurnoy_na.patterns.creational.factorymethod;

public abstract class TransportFactory {
    // Фабричный метод
    public abstract Transport createTransport();

    // Дополнительная логика (опционально)
    public void planDelivery() {
        Transport transport = createTransport();
        System.out.println("Планирование доставки...");
        transport.deliver();
    }
}