package ru.aston.ogurnoy_na.patterns.structural.bridge;

// Расширенный пульт (дополнительная функциональность)
public class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(Device device) {
        super(device);
    }

    public void mute() {
        device.setVolume(0);
        System.out.println("Устройство приглушено");
    }
}