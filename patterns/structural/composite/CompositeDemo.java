package ru.aston.ogurnoy_na.patterns.structural.composite;

public class CompositeDemo {
    public static void main(String[] args) {
        // Создаем файлы
        Component resume = new File("resume.pdf", 2.5);
        Component photo = new File("photo.jpg", 5.8);
        Component notes = new File("notes.txt", 0.3);

        // Создаем директории
        Directory documents = new Directory("Документы");
        Directory images = new Directory("Изображения");
        Directory root = new Directory("Корневая папка");

        // Заполняем структуру
        documents.add(resume);
        documents.add(notes);

        images.add(photo);

        root.add(documents);
        root.add(images);
        root.add(new File("readme.md", 0.1));

        // Выводим структуру
        root.showDetails();
    }
}