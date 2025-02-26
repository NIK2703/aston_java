package ru.aston.ogurnoy_na.patterns.behavioural.iterator;

import java.util.List;

public class TaskIterator implements Iterator<String> {
    private List<String> tasks;
    private int position = 0;

    public TaskIterator(List<String> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean hasNext() {
        return position < tasks.size();
    }

    @Override
    public String next() {
        if (hasNext()) {
            return tasks.get(position++);
        }
        return null; // или можно выбросить исключение
    }
}