package ru.aston.ogurnoy_na.patterns.structural.adapter;

public class USADevice {
    public void plugIntoUSASocket(USASocket socket) {
        int voltage = socket.provideUSAVoltage();
        System.out.println("Устройство подключено к USA розетке. Напряжение: " + voltage + "V");
    }
}