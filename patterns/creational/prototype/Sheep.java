package ru.aston.ogurnoy_na.patterns.creational.prototype;

public class Sheep implements Prototype {
    private String name;
    private String color;

    public Sheep(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public Sheep clone() throws CloneNotSupportedException {
        System.out.println("Клонирование овцы " + name);
        return (Sheep) super.clone();
    }

    @Override
    public String toString() {
        return "Sheep [name=" + name + ", color=" + color + "]";
    }
}