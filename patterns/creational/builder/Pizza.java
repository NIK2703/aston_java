package ru.aston.ogurnoy_na.patterns.creational.builder;

public class Pizza {
    private final String size;      // Обязательный параметр
    private final boolean cheese;   // Опциональный
    private final boolean pepperoni;// Опциональный
    private final boolean mushrooms;// Опциональный

    // Приватный конструктор (используется только через Builder)
    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
    }

    // Геттеры
    public String getSize() {
        return size;
    }

    public boolean hasCheese() {
        return cheese;
    }

    public boolean hasPepperoni() {
        return pepperoni;
    }

    public boolean hasMushrooms() {
        return mushrooms;
    }

    // Внутренний класс Builder
    public static class Builder {
        private final String size;  // Обязательный параметр
        private boolean cheese = false;
        private boolean pepperoni = false;
        private boolean mushrooms = false;

        // Конструктор Builder с обязательным параметром
        public Builder(String size) {
            this.size = size;
        }

        // Методы для опциональных параметров (возвращают this для цепочки)
        public Builder addCheese() {
            this.cheese = true;
            return this;
        }

        public Builder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        public Builder addMushrooms() {
            this.mushrooms = true;
            return this;
        }

        // Создание объекта Pizza
        public Pizza build() {
            return new Pizza(this);
        }
    }
}