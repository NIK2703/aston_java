package ru.aston.ogurnoy_na.patterns.creational.abstractfactory;

public class ClassicSofa implements Sofa {
    @Override
    public void lieDown() {
        System.out.println("Лежим на классическом диване 🛋️");
    }
}