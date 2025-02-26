package ru.aston.ogurnoy_na.patterns.behavioural.visitor;

public interface Element {
    void accept(Visitor visitor);
}