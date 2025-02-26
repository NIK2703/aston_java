package ru.aston.ogurnoy_na.patterns.structural.lightweight;

public class ForestDemo {
    public static void main(String[] args) {
        // Создаем лес
        Tree[] forest = {
                new Tree(10, 20, 5, TreeFactory.getTreeType("Сосна", "Зеленый", "Иголки")),
                new Tree(30, 40, 7, TreeFactory.getTreeType("Дуб", "Коричневый", "Кора")),
                new Tree(50, 60, 3, TreeFactory.getTreeType("Сосна", "Зеленый", "Иголки")),
                new Tree(70, 80, 10, TreeFactory.getTreeType("Береза", "Белый", "Листья"))
        };

        // Рисуем лес
        for (Tree tree : forest) {
            tree.draw();
        }

        System.out.println("\nВсего типов деревьев: " + TreeFactory.getTreeTypesCount());
        System.out.println("Всего деревьев: " + forest.length);
    }
}