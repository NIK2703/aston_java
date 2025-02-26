package ru.aston.ogurnoy_na.patterns.behavioural.visitor;

public class Main {
    public static void main(String[] args) {
        Element[] elements = {new Document(), new Image()};
        Visitor exportVisitor = new ExportVisitor();
        Visitor sendVisitor = new SendVisitor();

        // Применение операций к элементам
        for (Element element : elements) {
            element.accept(exportVisitor); // Экспорт
            element.accept(sendVisitor);  // Отправка
        }
    }
}