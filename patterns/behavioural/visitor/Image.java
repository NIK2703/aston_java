package ru.aston.ogurnoy_na.patterns.behavioural.visitor;

// Изображение
public class Image implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); // Вызов метода visit для Image
    }
}