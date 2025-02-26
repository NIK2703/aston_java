package ru.aston.ogurnoy_na.patterns.behavioural.templatemethod;

public abstract class Beverage {
    // Шаблонный метод (final, чтобы подклассы не могли изменить алгоритм)
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Общий шаг для всех напитков
    private void boilWater() {
        System.out.println("Кипятим воду");
    }

    // Абстрактные методы, которые должны реализовать подклассы
    protected abstract void brew();
    protected abstract void addCondiments();

    // Общий шаг с реализацией по умолчанию
    private void pourInCup() {
        System.out.println("Наливаем в чашку");
    }
}