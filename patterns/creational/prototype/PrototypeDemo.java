package ru.aston.ogurnoy_na.patterns.creational.prototype;

public class PrototypeDemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Пример с овцой Долли
        Sheep originalSheep = new Sheep("Долли", "белый");
        Sheep clonedSheep = originalSheep.clone();
        System.out.println("Оригинал: " + originalSheep);
        System.out.println("Клон: " + clonedSheep);

        // Пример с роботом (глубокое копирование)
        Robot terminator = new Robot("T-800", new Chip("v2.0"));
        Robot clonedTerminator = terminator.clone();
        System.out.println("\nОригинальный робот: " + terminator);
        System.out.println("Клонированный робот: " + clonedTerminator);
    }
}