package ru.aston.ogurnoy_na.patterns.creational.abstractfactory;

public class Client {
    public static void main(String[] args) {
        // Создаем классическую мебель
        FurnitureFactory classicFactory = new ClassicFurnitureFactory();
        Chair classicChair = classicFactory.createChair();
        Table classicTable = classicFactory.createTable();
        classicChair.sitOn();
        classicTable.putItem();

        // Создаем современную мебель
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Sofa modernSofa = modernFactory.createSofa();
        modernSofa.lieDown();
    }
}