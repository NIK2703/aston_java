package ru.aston.ogurnoy_na.patterns.creational.abstractfactory;

public class ModernSofa implements Sofa {
    @Override
    public void lieDown() {
        System.out.println("Отдыхаем на минималистичном диване 🛋️✨");
    }
}