package ru.aston.ogurnoy_na.patterns.behavioural.templatemethod;

public class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Завариваем кофе");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Добавляем молоко и сахар");
    }
}