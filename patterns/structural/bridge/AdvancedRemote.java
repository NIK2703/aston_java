package ru.aston.ogurnoy_na.patterns.structural.bridge;

public class AdvancedRemote extends RemoteControl {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        device.setVolume(0);
        System.out.println("Режим тишины активирован 🔇");
    }
}