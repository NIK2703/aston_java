package ru.aston.ogurnoy_na.patterns.structural.adapter;

public class EuropeanSocketImpl implements EuropeanSocket {
    @Override
    public int provideEUVoltage() {
        return 220; // 220V (европейский стандарт)
    }
}