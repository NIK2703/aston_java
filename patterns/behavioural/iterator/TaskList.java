package ru.aston.ogurnoy_na.patterns.behavioural.iterator;

import java.util.ArrayList;
import java.util.List;

public class TaskList implements IterableCollection<String> {
    private List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    @Override
    public Iterator<String> createIterator() {
        return new TaskIterator(tasks);
    }
}