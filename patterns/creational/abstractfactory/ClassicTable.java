package ru.aston.ogurnoy_na.patterns.creational.abstractfactory;

public class ClassicTable implements Table {
    @Override
    public void putItem() {
        System.out.println("Ставим вазу на классический стол 🏺");
    }
}