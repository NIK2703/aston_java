package ru.aston.ogurnoy_na.patterns.structural.adapter;

public class Client {
    public static void main(String[] args) {
        // Европейская розетка
        EuropeanSocket europeanSocket = new EuropeanSocketImpl();

        // Адаптер для USA устройства
        USASocket adapter = new SocketAdapter(europeanSocket);

        // Подключение USA устройства через адаптер
        USADevice device = new USADevice();
        device.plugIntoUSASocket(adapter);
        // Вывод: Устройство подключено к USA розетке. Напряжение: 110V
    }
}