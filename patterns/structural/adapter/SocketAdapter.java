package ru.aston.ogurnoy_na.patterns.structural.adapter;

public class SocketAdapter implements USASocket {
    private EuropeanSocket europeanSocket;

    public SocketAdapter(EuropeanSocket europeanSocket) {
        this.europeanSocket = europeanSocket;
    }

    @Override
    public int provideUSAVoltage() {
        int euVoltage = europeanSocket.provideEUVoltage();
        return euVoltage / 2; // Преобразуем 220V в 110V
    }
}