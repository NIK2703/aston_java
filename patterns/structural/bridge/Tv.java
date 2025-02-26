package ru.aston.ogurnoy_na.patterns.structural.bridge;

// Телевизор
public class Tv implements Device {
    private boolean isEnabled = false;
    private int volume = 50;

    @Override
    public void enable() {
        isEnabled = true;
        System.out.println("Телевизор включен");
    }

    @Override
    public void disable() {
        isEnabled = false;
        System.out.println("Телевизор выключен");
    }

    @Override
    public void setVolume(int percent) {
        volume = Math.min(100, Math.max(0, percent));
        System.out.println("Громкость телевизора: " + volume + "%");
    }

    @Override
    public int getVolume() {
        return volume;
    }
}