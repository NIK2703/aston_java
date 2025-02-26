# Паттерн Строитель (Builder)

## Назначение
Паттерн **Строитель** разделяет создание сложного объекта на отдельные шаги, позволяя использовать один и тот же процесс конструирования для получения разных представлений объекта. Он решает проблему "телескопических конструкторов" (множества перегрузок с разными параметрами) и упрощает создание объектов с большим количеством опциональных параметров.

## Структура

1. **`Product`** (Продукт):
    - Сложный объект, который нужно создать (например, `Pizza`).

2. **`Builder`** (Интерфейс/Абстрактный класс):
    - Объявляет шаги конструирования, общие для всех типов продуктов. В Java часто заменяется внутренним классом.

3. **`ConcreteBuilder`** (Конкретный строитель):
    - Реализует шаги, опредленные в `Builder`.
    - Предоставляет метод `build()` для возврата готового продукта.

4. **`Director`** (Опционально):
    - Управляет порядком вызова шагов строителя. Часто опускается, если объект можно собрать напрямую через `Builder`.

## Преимущества
- **Гибкость**: Позволяет создавать объекты с разными параметрами, не загромождая код конструкторами.
- **Пошаговое конструирование**: Можно контролировать процесс сборки.
- **Изоляция сложности**: Логика создания объекта инкапсулирована в `Builder`.
- **Переиспользование кода**: Один `Builder` может использоваться для создания разных продуктов.

## Когда использовать?
- Объект имеет много опциональных параметров.
- Требуется создавать разные представления объекта (например, вегетарианскую пиццу и пиццу с мясом).
- Процесс создания объекта должен быть независимым от его частей.

## Примеры применения
- Конструирование SQL-запросов.
- Создание GUI-элементов с множеством настроек (цвет, шрифт, размер).
- Генерация отчетов в разных форматах (PDF, HTML).

## Пример из кода
В примере выше:
- `Pizza` — продукт с обязательным (`size`) и опциональными (`cheese`, `pepperoni`, `mushrooms`) параметрами.
- `Pizza.Builder` позволяет гибко задавать параметры через цепочку методов:
  ```java
  Pizza pizza = new Pizza.Builder("Large")
          .addCheese()
          .addPepperoni()
          .build();
  ```