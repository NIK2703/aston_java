package ru.aston.ogurnoy_na.patterns.behavioural.visitor;

// Документ
public class Document implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); // Вызов метода visit для Document
    }
}