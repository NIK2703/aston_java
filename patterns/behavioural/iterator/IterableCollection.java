package ru.aston.ogurnoy_na.patterns.behavioural.iterator;

public interface IterableCollection<T> {
    Iterator<T> createIterator();
}