package ru.aston.ogurnoy_na.patterns.behavioural.visitor;

// Посетитель для экспорта
public class ExportVisitor implements Visitor {
    @Override
    public void visit(Document doc) {
        System.out.println("Экспорт документа...");
    }

    @Override
    public void visit(Image img) {
        System.out.println("Экспорт изображения...");
    }
}