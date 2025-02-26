**Структурные паттерны проектирования** — это категория шаблонов, которые решают задачи, связанные с **композицией классов и объектов**. Они помогают организовать взаимодействие между сущностями, упростить структуру системы и сделать её более гибкой, сохраняя при этом эффективность. Эти паттерны фокусируются на том, как объекты и классы объединяются в более крупные структуры, не нарушая их независимость.

---

### **Основные цели:**
- **Упростить взаимодействие** между компонентами системы.
- **Снизить связанность** между классами и объектами.
- **Повысить переиспользуемость** кода.
- **Адаптировать интерфейсы** для совместной работы несовместимых компонентов.
- **Оптимизировать использование ресурсов** (например, памяти).

---

### **Ключевые паттерны:**

1. **Адаптер (Adapter)**  
   *Преобразует интерфейс одного класса в интерфейс, ожидаемый клиентом.*  
   **Пример:** Переходник для зарядки (адаптация USB-C к Micro-USB) или интеграция старой библиотеки в новую систему.

2. **Мост (Bridge)**  
   *Разделяет абстракцию и реализацию, чтобы они могли изменяться независимо.*  
   **Пример:** Управление разными типами пультов (абстракция) и устройств (реализация: телевизор, кондиционер).

3. **Компоновщик (Composite)**  
   *Объединяет объекты в древовидные структуры, позволяя работать с ними как с единым целым.*  
   **Пример:** Файловая система (папки и файлы обрабатываются одинаково через общий интерфейс).

4. **Декоратор (Decorator)**  
   *Динамически добавляет объекту новые обязанности, оборачивая его.*  
   **Пример:** Добавление функционала к кофе (молоко, сироп) без изменения базового класса.

5. **Фасад (Facade)**  
   *Предоставляет простой интерфейс для работы со сложной подсистемой.*  
   **Пример:** Один интерфейс для управления домашним кинотеатром (включение ТВ, звука, света).

6. **Приспособленец (Flyweight)**  
   *Экономит память, разделяя общее состояние между множеством объектов.*  
   **Пример:** Хранение общих характеристик деревьев в игре (текстура, цвет) для тысяч экземпляров.

7. **Заместитель (Proxy)**  
   *Контролирует доступ к объекту, добавляя промежуточный уровень.*  
   **Пример:** Ленивая загрузка изображений, кэширование данных или защита доступа к敏感ным ресурсам.

---

### **Когда применять?**
- Нужно **интегрировать несовместимые интерфейсы** → **Адаптер**.
- Требуется **разделить абстракцию и реализацию** для гибкости → **Мост**.
- Необходимо **упростить сложную систему** → **Фасад**.
- Нужно **динамически добавлять функционал** → **Декоратор**.
- Требуется **оптимизировать использование ресурсов** → **Приспособленец**.
- Нужно **контролировать доступ к объекту** → **Заместитель**.

---

### **Примеры из реального мира:**
- **Веб-разработка:**
    - *Фасад* для работы с API платежных систем (Stripe, PayPal).
    - *Декоратор* для добавления логирования или проверки прав доступа к методам.
- **Игры:**
    - *Компоновщик* для управления группами юнитов (армии, отряды).
    - *Приспособленец* для рендеринга множества одинаковых объектов (трава, пули).
- **Базы данных:**
    - *Заместитель* для ленивой загрузки данных или кэширования запросов.

---

**Итог:** Структурные паттерны помогают создавать понятные, масштабируемые и эффективные архитектуры, упрощая взаимодействие между компонентами. Они часто используются вместе с **порождающими** (для создания объектов) и **поведенческими** (для управления логикой) паттернами, образуя комплексное решение для проектирования сложных систем.