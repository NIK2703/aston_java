package ru.aston.ogurnoy_na.patterns.structural.composite;

public interface Component {
    void showDetails();
    void add(Component component);
    void remove(Component component);
}