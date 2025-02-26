package ru.aston.ogurnoy_na.patterns.creational.abstractfactory;

public class ModernTable implements Table {
    @Override
    public void putItem() {
        System.out.println("Ставим ноутбук на стеклянный стол 💻");
    }
}