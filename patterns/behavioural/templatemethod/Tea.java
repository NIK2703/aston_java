package ru.aston.ogurnoy_na.patterns.behavioural.templatemethod;

public class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Завариваем чайные листья");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Добавляем лимон");
    }
}