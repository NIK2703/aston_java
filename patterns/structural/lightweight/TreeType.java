package ru.aston.ogurnoy_na.patterns.structural.lightweight;

public class TreeType {
    private final String name; // Внутреннее состояние (общее)
    private final String color;
    private final String texture;

    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void draw(int x, int y, int age) { // Внешнее состояние передается как параметры
        System.out.printf("Рисуем %s дерево [Цвет: %s, Текстура: %s] в (%d, %d), Возраст: %d лет\n",
                name, color, texture, x, y, age);
    }
}