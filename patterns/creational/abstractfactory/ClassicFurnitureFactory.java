package ru.aston.ogurnoy_na.patterns.creational.abstractfactory;

public class ClassicFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ClassicChair();
    }

    @Override
    public Table createTable() {
        return new ClassicTable();
    }

    @Override
    public Sofa createSofa() {
        return new ClassicSofa();
    }
}