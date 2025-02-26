package ru.aston.ogurnoy_na.patterns.behavioural.memento;

public class Editor {
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    // Создает снимок текущего состояния
    public Memento createMemento() {
        return new Memento(content);
    }

    // Восстанавливает состояние из снимка
    public void restore(Memento memento) {
        this.content = memento.content;
    }

    // Внутренний класс Memento
    public static class Memento {
        private final String content;

        // Приватный конструктор
        private Memento(String content) {
            this.content = content;
        }
    }
}