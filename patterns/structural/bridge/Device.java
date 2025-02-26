package ru.aston.ogurnoy_na.patterns.structural.bridge;

public interface Device {
    void enable();          // Включить устройство
    void disable();         // Выключить устройство
    void setVolume(int percent); // Установить громкость
    int getVolume();        // Получить текущую громкость
}