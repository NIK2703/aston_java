package ru.aston.ogurnoy_na.patterns.structural.lightweight;

public class Tree {
    private int x;
    private int y;
    private int age;
    private TreeType type; // Ссылка на легковес

    public Tree(int x, int y, int age, TreeType type) {
        this.x = x;
        this.y = y;
        this.age = age;
        this.type = type;
    }

    public void draw() {
        type.draw(x, y, age);
    }
}