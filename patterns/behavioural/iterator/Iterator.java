package ru.aston.ogurnoy_na.patterns.behavioural.iterator;

public interface Iterator<T> {
    boolean hasNext();
    T next();
}