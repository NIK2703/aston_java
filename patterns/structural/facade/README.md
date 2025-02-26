# Описание паттерна "Фасад" (Facade)

## Назначение
**Фасад** предоставляет унифицированный интерфейс для набора интерфейсов в подсистеме. Упрощает работу со сложной системой, скрывая её внутреннюю логику за простым API.

## Структура
1. **Фасад** (`HomeTheaterFacade`):
    - Знает, каким классам подсистемы делегировать запросы
    - Предоставляет простые методы для клиента
2. **Подсистемные классы** (`Amplifier`, `DvdPlayer` и др.):
    - Реализуют функциональность подсистемы
    - Не зависят от фасада

## Пример работы
При вызове `watchMovie("Фильм")`:
```
1. Опускает экран
2. Включает проектор
3. Включает усилитель
4. Устанавливает громкость
5. Включает DVD и начинает воспроизведение
```

## Преимущества
- ⚡ **Упрощает взаимодействие**: Клиент работает с одним объектом вместо десятков
- 🛡️ **Снижает связанность**: Изолирует клиента от внутренних компонентов
- 🧩 **Легкость модификации**: Изменения в подсистеме не затрагивают клиентский код

## Недостатки
- 🧨 Риск создания "божественного объекта" (слишком много ответственности)
- 🔓 Может ограничивать гибкость для продвинутых пользователей

## Когда использовать?
- Когда нужно предоставить простой интерфейс к сложной подсистеме
- Для разложения системы на слои абстракции
- Примеры:
    - Упрощение работы с API фреймворков
    - Управление комплексными бизнес-процессами
    - Инициализация сложных объектов