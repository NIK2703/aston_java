package ru.aston.ogurnoy_na.patterns.behavioural.visitor;

// Посетитель для отправки
public class SendVisitor implements Visitor {
    @Override
    public void visit(Document doc) {
        System.out.println("Отправка документа...");
    }

    @Override
    public void visit(Image img) {
        System.out.println("Отправка изображения...");
    }
}