package ru.aston.ogurnoy_na.patterns.behavioural.visitor;

public interface Visitor {
    void visit(Document doc); // Метод для работы с Document
    void visit(Image img);    // Метод для работы с Image
}