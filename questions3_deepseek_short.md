### 1. Что такое Stream API?
Stream API в Java — это набор инструментов для обработки данных в функциональном стиле. Он позволяет выполнять операции (фильтрацию, преобразование, агрегацию) над коллекциями, массивами и другими источниками данных.  
**Особенности**:
- Не изменяет исходные данные.
- Ленивые (промежуточные) и энергичные (терминальные) операции.
- Поддержка параллельной обработки.

### 2. Основные преимущества Stream API
- **Читаемость**: Лаконичный и декларативный код.
- **Функциональное программирование**: Чистые функции и иммутабельность.
- **Параллелизм**: Простое распараллеливание через `parallelStream()`.
- **Оптимизация**: Ленивые вычисления и короткое замыкание.

### 3. Основные операции
- **Промежуточные**: `filter`, `map`, `sorted`, `distinct`.
- **Терминальные**: `collect`, `forEach`, `reduce`, `count`.

### 4. Объединение Stream
- `Stream.concat(a, b)` для двух потоков.
- `flatMap` для объединения нескольких потоков:
  ```java
  List<Stream<String>> streams = ...;
  Stream<String> merged = streams.stream().flatMap(Function.identity());
  ```

### 5. Обработка ошибок
- **Внутри лямбды**: Использовать `try-catch`.
- **Обертка исключений**:
  ```java
  .map(s -> {
      try { return parse(s); } 
      catch (Exception e) { throw new RuntimeException(e); }
  })
  ```

### 6. Методы фильтрации
- `filter(Predicate<T>)`:
  ```java
  stream.filter(s -> s.length() > 3);
  ```

### 7. Collectors.groupingBy()
Группирует элементы по ключу:
```java
Map<Integer, List<String>> groups = stream.collect(
    Collectors.groupingBy(String::length)
);
```

### 8. Преобразование типов данных
- `int[]` → `List<Integer>`:
  ```java
  Arrays.stream(intArray).boxed().collect(Collectors.toList());
  ```

### 9. Отличие flatMap от map
- **map**: Преобразует элемент в другой объект.
- **flatMap**: Преобразует элемент в поток и объединяет потоки.

### 10. Параллельные потоки
- Создание: `list.parallelStream()` или `stream.parallel()`.
- **Важно**: Потокобезопасность и ассоциативность операций.

### 11. Метод forEach
- Терминальная операция: `stream.forEach(System.out::println)`.

### 12. Метод peek
- Промежуточная операция для отладки:
  ```java
  .peek(s -> System.out.println("Processing: " + s))
  ```

### 13. Метод reduce
Сворачивает элементы в одно значение:
```java
int sum = stream.reduce(0, (a, b) -> a + b);
```

### 14. Бесконечные потоки
Создание через `Stream.iterate` или `Stream.generate`:
```java
Stream<Integer> infinite = Stream.iterate(0, n -> n + 1);
```

### 15. Ограничения Stream API
- Неизменяемость данных.
- Однократное использование.
- Накладные расходы для простых операций.

### 16. Передача переменных в Stream
- Локальные переменные должны быть effectively final.
- Для изменяемых переменных использовать массив или `Atomic`-классы:
  ```java
  int[] counter = {0};
  stream.forEach(s -> counter[0]++);
  ```

### 17. Создание Optional
- `Optional.of(value)` (не null).
- `Optional.ofNullable(value)` (может быть null).
- `Optional.empty()`.

### 18. Отличие Optional.of() и ofNullable()
- `of(null)` → `NullPointerException`.
- `ofNullable(null)` → пустой Optional.

### 19. Методы ifPresent и orElse
- **ifPresent**: Выполняет действие, если значение есть.
- **orElse**: Возвращает значение или дефолт.

### 20. Объединение Optional
- Через `flatMap` и `map`:
  ```java
  Optional<String> result = opt1.flatMap(a -> opt2.map(b -> a + b));
  ```

### 21. ifPresent Optional
Проверяет наличие значения:
```java
optional.ifPresent(v -> System.out.println(v));
```

### 22. Преобразование Stream в коллекцию/массив
- **Массив**: `stream.toArray(String[]::new)`.
- **Коллекция**: `stream.collect(Collectors.toList())`.

### 23. orElse vs orElseGet
- **orElse**: Значение вычисляется всегда.
- **orElseGet**: Значение вычисляется лениво.

### 24. Обработка ошибок с orElseThrow
Бросает исключение, если значение отсутствует:
```java
String value = optional.orElseThrow(() -> new Exception("Not found"));
```
