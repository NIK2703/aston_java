package ru.aston.ogurnoy_na.patterns.structural.composite;

public class File implements Component {
    private String name;
    private double size; // в мегабайтах

    public File(String name, double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.printf("Файл: %-15s | Размер: %.1f MB\n", name, size);
    }

    // Методы add/remove не поддерживаются для листовых элементов
    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Нельзя добавить к файлу");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Нельзя удалить из файла");
    }
}