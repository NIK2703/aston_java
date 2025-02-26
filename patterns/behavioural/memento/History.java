package ru.aston.ogurnoy_na.patterns.behavioural.memento;

import java.util.Stack;

public class History {
    private final Stack<Editor.Memento> states = new Stack<>();

    // Сохраняет снимок в истории
    public void push(Editor.Memento memento) {
        states.push(memento);
    }

    // Извлекает последний снимок
    public Editor.Memento pop() {
        return states.pop();
    }
}