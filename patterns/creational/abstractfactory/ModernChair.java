package ru.aston.ogurnoy_na.patterns.creational.abstractfactory;

public class ModernChair implements Chair {
    @Override
    public void sitOn() {
        System.out.println("Сидя на современном стуле 🪑💺");
    }
}