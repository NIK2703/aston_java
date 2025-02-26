package ru.aston.ogurnoy_na.patterns.creational.prototype;

public class Robot implements Prototype {
    private String model;
    private Chip chip;

    public Robot(String model, Chip chip) {
        this.model = model;
        this.chip = chip;
    }

    @Override
    public Robot clone() throws CloneNotSupportedException {
        Robot cloned = (Robot) super.clone();
        cloned.chip = new Chip(this.chip.getVersion()); // Глубокое копирование
        return cloned;
    }

    @Override
    public String toString() {
        return "Robot [model=" + model + ", chip=" + chip + "]";
    }
}
