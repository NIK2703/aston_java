package ru.aston.ogurnoy_na.patterns.creational.abstractfactory;

public class ClassicChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Сидя на классическом стуле 🪑");
    }
}