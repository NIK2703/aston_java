package ru.aston.ogurnoy_na.patterns.creational.abstractfactory;

public interface FurnitureFactory {
    Chair createChair();
    Table createTable();
    Sofa createSofa();
}