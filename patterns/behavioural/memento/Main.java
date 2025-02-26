package ru.aston.ogurnoy_na.patterns.behavioural.memento;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.setContent("State 1");
        history.push(editor.createMemento());

        editor.setContent("State 2");
        history.push(editor.createMemento());

        // Восстановление предыдущего состояния
        editor.restore(history.pop());
        System.out.println(editor.getContent()); // State 2

        editor.restore(history.pop());
        System.out.println(editor.getContent()); // State 1
    }
}