package ru.aston.ogurnoy_na.patterns.structural.bridge;

// Радио
public class Radio implements Device {
    private boolean isEnabled = false;
    private int volume = 30;

    @Override
    public void enable() {
        isEnabled = true;
        System.out.println("Радио включено");
    }

    @Override
    public void disable() {
        isEnabled = false;
        System.out.println("Радио выключено");
    }

    @Override
    public void setVolume(int percent) {
        volume = Math.min(100, Math.max(0, percent));
        System.out.println("Громкость радио: " + volume + "%");
    }

    @Override
    public int getVolume() {
        return volume;
    }
}