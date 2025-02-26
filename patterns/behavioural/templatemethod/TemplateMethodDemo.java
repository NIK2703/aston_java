package ru.aston.ogurnoy_na.patterns.behavioural.templatemethod;

public class TemplateMethodDemo {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        Beverage coffee = new Coffee();

        System.out.println("Готовим чай:");
        tea.prepareRecipe();

        System.out.println("\nГотовим кофе:");
        coffee.prepareRecipe();
    }
}