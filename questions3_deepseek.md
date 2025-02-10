### 1. Что такое Stream API?
Stream API в Java — это набор инструментов, введенный в Java 8, для обработки последовательностей данных (например, коллекций, массивов) в **функциональном стиле**. Он позволяет выполнять сложные операции (фильтрацию, преобразование, агрегацию) с данными лаконично и декларативно, используя цепочки методов. Вот ключевые аспекты:

---

### **Основные особенности Stream API**
1. **Не изменяет исходные данные**  
   Стримы не модифицируют исходную коллекцию или массив, а создают новый поток обработанных данных.

2. **Ленивые и энергичные операции**  
   - **Промежуточные операции** (например, `filter()`, `map()`, `sorted()`) — «ленивые», выполняются только при вызове терминальной операции.  
   - **Терминальные операции** (например, `collect()`, `forEach()`, `count()`) — запускают обработку данных и возвращают результат.

3. **Поддержка параллелизма**  
   Параллельные стримы (`parallelStream()`) автоматически распределяют обработку данных между потоками, упрощая многопоточные операции.

---

### **Пример использования**
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

// Фильтрация, преобразование, сбор в список
List<String> result = names.stream()
    .filter(name -> name.length() > 3)       // Оставить имена длиннее 3 символов
    .map(String::toUpperCase)               // Преобразовать в верхний регистр
    .collect(Collectors.toList());          // Собрать в список

System.out.println(result); // [ALICE, CHARLIE, DAVID]
```

---

### **Популярные операции**
- **Промежуточные**:  
  `filter(Predicate<T>)`, `map(Function<T, R>)`, `sorted()`, `distinct()`, `limit(n)`.
- **Терминальные**:  
  `collect(Collectors.toList())`, `forEach(Consumer<T>)`, `count()`, `reduce()`, `anyMatch()`, `findFirst()`.

---

### **Преимущества**
- **Читаемость**: Код становится более выразительным и компактным.
- **Оптимизация**: Ленивые операции и внутренние оптимизации (например, краткое замыкание в `findFirst()`).
- **Параллелизм**: Простое распараллеливание без явного управления потоками.

---

### **Ограничения**
- **Однократное использование**: Стрим нельзя повторно использовать после терминальной операции.
- **Производительность**: В некоторых случаях традиционные циклы могут быть эффективнее (особенно для простых операций).
- **Отладка**: Цепочки методов сложнее отлаживать пошагово.

---

### **Источники стримов**
Стримы можно создать из:
- Коллекций (`list.stream()`),
- Массивов (`Arrays.stream(array)`),
- Файлов (`Files.lines(path)`),
- Генераторов (`Stream.iterate()`, `Stream.generate()`).

---

Stream API идеально подходит для обработки данных в функциональном стиле, заменяя громоздкие циклы и итераторы. Однако важно учитывать контекст: для простых операций или критичных к производительности участков традиционные подходы могут быть предпочтительнее.

---
---
### 2. Каковы основные преимущества использования Stream API?
Основные преимущества Stream API в Java связаны с **удобством, читаемостью** и **эффективностью** обработки данных. Вот ключевые плюсы:

---

### 1. **Декларативный и лаконичный код**
Stream API позволяет описывать **что нужно сделать**, а не **как это сделать**. Это сокращает объем шаблонного кода и делает его более выразительным.

**Пример:**
```java
// Императивный подход (циклы + условия)
List<String> filteredNames = new ArrayList<>();
for (String name : names) {
    if (name.length() > 3) {
        filteredNames.add(name.toUpperCase());
    }
}

// Через Stream API
List<String> filteredNames = names.stream()
    .filter(name -> name.length() > 3)
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

---

### 2. **Функциональное программирование**
- **Чистые функции**: Операции вроде `map`, `filter` не имеют побочных эффектов (не изменяют исходные данные).
- **Ленивые вычисления**: Промежуточные операции (например, `filter`, `sorted`) выполняются только при вызове терминальной операции (например, `collect`), что экономит ресурсы.

---

### 3. **Параллелизм без явного управления потоками**
Можно легко переключиться на параллельную обработку данных, используя `parallelStream()`. Stream API автоматически распределяет задачи между ядрами процессора.

```java
List<String> result = names.parallelStream() // Параллельный стрим
    .filter(name -> name.length() > 3)
    .collect(Collectors.toList());
```

---

### 4. **Оптимизация производительности**
- **Короткое замыкание**: Некоторые операции (например, `findFirst()`, `anyMatch()`) останавливают обработку, как только результат найден.
- **Слияние операций**: Внутренние оптимизации Stream API объединяют несколько операций в один проход по данным.

---

### 5. **Универсальность и гибкость**
- **Цепочка операций**: Можно комбинировать фильтрацию, преобразование, сортировку и другие действия в одной цепочке.
- **Поддержка разнообразных источников**: Коллекции, массивы, файлы, генераторы, I/O-потоки.

---

### 6. **Интеграция с современными возможностями Java**
- **Лямбда-выражения и ссылки на методы**: Stream API идеально сочетается с функциональными фичами Java 8+.
- **Стандартные коллекторы**: Готовые решения для группировки (`groupingBy`), агрегации (`summingInt`, `averagingDouble`) и других операций через `Collectors`.

```java
// Группировка по длине строки
Map<Integer, List<String>> groupedByNameLength = names.stream()
    .collect(Collectors.groupingBy(String::length));
```

---

### 7. **Удобство тестирования и модульности**
Каждую операцию в цепочке можно тестировать отдельно, так как они являются независимыми функциями.

---

### 8. **Сокращение ошибок**
- **Иммутабельность**: Исходные данные не изменяются, что снижает риск неожиданных сайд-эффектов.
- **Нет явных индексов**: Исключаются ошибки вроде `IndexOutOfBoundsException`.

---

### Когда Stream API особенно полезен?
- Обработка больших данных (особенно в параллельном режиме).
- Сложные цепочки операций (фильтрация + преобразование + группировка).
- Работа с коллекциями в функциональном стиле.

---

### Ограничения (важно помнить!)
- **Производительность**: Для простых операций (например, перебор без преобразований) циклы `for`/`forEach` могут быть быстрее.
- **Отладка**: Сложнее отслеживать промежуточные значения в цепочке стримов.
- **Однократное использование**: После терминальной операции стрим нельзя переиспользовать.

---

Stream API — это инструмент, который **упрощает работу с данными**, но его стоит применять осознанно, учитывая контекст задачи.

---
---
### 3. Какие основные операции доступны в Stream API?
В Stream API в Java операции делятся на **промежуточные** (lazy, формируют цепочку обработки) и **терминальные** (завершают поток, запускают выполнение). Вот основные операции:

---

### **Промежуточные операции**  
Обрабатывают данные и возвращают новый поток. Не выполняются до вызова терминальной операции.

1. **`filter(Predicate<T>)`**  
   Отфильтровывает элементы по условию.  
   ```java
   stream.filter(x -> x > 10) // Оставляет числа больше 10
   ```

2. **`map(Function<T, R>)`**  
   Преобразует каждый элемент в другой объект.  
   ```java
   stream.map(String::length) // Преобразует строки в их длины
   ```

3. **`sorted()` / `sorted(Comparator<T>)`**  
   Сортирует элементы.  
   ```java
   stream.sorted() // Естественная сортировка
   stream.sorted((a, b) -> b - a) // Сортировка по убыванию
   ```

4. **`distinct()`**  
   Удаляет дубликаты (использует `equals()`).  
   ```java
   stream.distinct() // Уникальные элементы
   ```

5. **`limit(long n)`**  
   Ограничивает поток первыми `n` элементами.  
   ```java
   stream.limit(5) // Первые 5 элементов
   ```

6. **`skip(long n)`**  
   Пропускает первые `n` элементов.  
   ```java
   stream.skip(3) // Пропустить первые 3 элемента
   ```

7. **`peek(Consumer<T>)`**  
   Выполняет действие для каждого элемента (например, логирование).  
   ```java
   stream.peek(System.out::println) // Вывести элементы
   ```

---

### **Терминальные операции**  
Завершают поток и возвращают результат (или `void`).

1. **`collect(Collector<T, A, R>)`**  
   Преобразует поток в коллекцию или агрегирует данные.  
   ```java
   List<String> list = stream.collect(Collectors.toList()); // В список
   Map<Integer, List<String>> groups = stream.collect(Collectors.groupingBy(String::length)); // Группировка по длине
   ```

2. **`forEach(Consumer<T>)`**  
   Выполняет действие для каждого элемента.  
   ```java
   stream.forEach(System.out::println); // Вывод всех элементов
   ```

3. **`reduce(...)`**  
   Сворачивает элементы в одно значение (например, сумму).  
   ```java
   int sum = stream.reduce(0, (a, b) -> a + b); // Сумма чисел
   ```

4. **`count()`**  
   Возвращает количество элементов в потоке.  
   ```java
   long count = stream.count(); // Размер потока
   ```

5. **`anyMatch(Predicate<T>)` / `allMatch()` / `noneMatch()`**  
   Проверяют, удовлетворяет ли поток условию:  
   - `anyMatch`: хотя бы один элемент;  
   - `allMatch`: все элементы;  
   - `noneMatch`: ни один элемент.  
   ```java
   boolean hasNegative = stream.anyMatch(x -> x < 0); // Есть ли отрицательные?
   ```

6. **`findFirst()` / `findAny()`**  
   Возвращают первый/любой элемент потока (часто с `filter`).  
   ```java
   Optional<String> first = stream.findFirst(); // Первый элемент
   ```

7. **`min(Comparator<T>)` / `max(Comparator<T>)`**  
   Находят минимальный/максимальный элемент.  
   ```java
   Optional<Integer> max = stream.max(Integer::compare); // Максимум
   ```

---

### Пример цепочки операций
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

List<String> result = numbers.stream()
    .filter(n -> n % 2 == 0)     // [2, 4, 6]
    .map(n -> "Число: " + n)     // ["Число: 2", "Число: 4", "Число: 6"]
    .sorted(Comparator.reverseOrder()) // Сортировка строк в обратном порядке
    .collect(Collectors.toList()); 

// Результат: ["Число: 6", "Число: 4", "Число: 2"]
```

---

### Важные особенности
- **Однократное использование**: После терминальной операции поток закрывается.
- **Ленивые вычисления**: Промежуточные операции выполняются только при вызове терминальной.
- **Параллельные потоки**: Можно использовать `parallelStream()` для многопоточной обработки.

Stream API делает код чище и выразительнее, но для простых задач (например, перебора) циклы иногда эффективнее.

---
---
### 4. Как можно объединять несколько Stream с помощью Stream API?
В Java Stream API есть несколько способов объединить (конкатенировать) несколько потоков (`Stream`). Вот основные методы:

---

### 1. **`Stream.concat()` — для объединения двух потоков**
Метод `Stream.concat(a, b)` объединяет два потока `a` и `b` в один.  
**Пример:**
```java
Stream<String> stream1 = Stream.of("A", "B");
Stream<String> stream2 = Stream.of("C", "D");

Stream<String> mergedStream = Stream.concat(stream1, stream2);

mergedStream.forEach(System.out::print); // ABCD
```

**Ограничение:**  
Метод `concat()` принимает только два потока. Для объединения **трех и более** потоков его нужно вызывать последовательно:
```java
Stream<String> stream3 = Stream.of("E", "F");
Stream<String> merged = Stream.concat(Stream.concat(stream1, stream2), stream3);
```

---

### 2. **`flatMap()` — для объединения нескольких потоков**
Если у вас есть коллекция потоков, можно использовать `flatMap()`, чтобы объединить их в один:
```java
List<Stream<String>> streams = Arrays.asList(
    Stream.of("A", "B"),
    Stream.of("C", "D"),
    Stream.of("E", "F")
);

Stream<String> mergedStream = streams.stream()
    .flatMap(Function.identity()); // "Разворачивает" потоки

mergedStream.forEach(System.out::print); // ABCDEF
```

---

### 3. **Сбор потоков в коллекцию и создание нового**
Если потоки содержат элементы одного типа, можно собрать их в общую коллекцию и создать новый поток:
```java
Stream<String> stream1 = Stream.of("A", "B");
Stream<String> stream2 = Stream.of("C", "D");

List<String> list = Stream.concat(stream1, stream2).toList();
Stream<String> mergedStream = list.stream();
```

---

### 4. **Для примитивных потоков (IntStream, LongStream, DoubleStream)**
Используйте метод `concat()` для соответствующих типов:
```java
IntStream stream1 = IntStream.of(1, 2);
IntStream stream2 = IntStream.of(3, 4);
IntStream merged = IntStream.concat(stream1, stream2);
```

---

### 5. **Объединение через `Stream.of()` и `flatMap()` (для нескольких потоков)**
```java
Stream<String> mergedStream = Stream.of(stream1, stream2, stream3)
    .flatMap(Function.identity());
```

---

### Важные нюансы:
- **Порядок элементов**: Элементы объединяются в порядке добавления потоков.
- **Закрытие потоков**: После объединения исходные потоки **нельзя использовать** (они считаются обработанными).
- **Производительность**: Для большого числа потоков предпочтительнее `flatMap()`, так как `concat()` создает древовидную структуру, что может замедлить выполнение.

---

### Пример: объединение трех потоков
```java
Stream<Integer> stream1 = Stream.of(1, 2);
Stream<Integer> stream2 = Stream.of(3, 4);
Stream<Integer> stream3 = Stream.of(5, 6);

// Способ 1: через последовательный concat()
Stream<Integer> merged1 = Stream.concat(Stream.concat(stream1, stream2), stream3);

// Способ 2: через flatMap()
Stream<Integer> merged2 = Stream.of(stream1, stream2, stream3)
    .flatMap(Function.identity());

merged2.forEach(System.out::print); // 123456
```

---

### Когда использовать?
- `Stream.concat()` — для объединения **2 потоков**.
- `flatMap()` — для объединения **многих потоков** или если потоки хранятся в коллекции.

---
---
### 5. Как использовать Stream API для обработки ошибок?
Обработка ошибок в Stream API Java требует особого подхода, так как лямбда-выражения внутри стримов **не поддерживают проброс проверяемых исключений** (checked exceptions). Рассмотрим основные методы обработки ошибок.

---

### 1. **Обработка исключений внутри лямбды**
Оборачивайте код, который может выбросить исключение, в `try-catch` внутри лямбды.

```java
List<String> fileNames = Arrays.asList("file1.txt", "file2.txt");

List<String> lines = fileNames.stream()
    .flatMap(fileName -> {
        try {
            return Files.lines(Paths.get(fileName));
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + fileName);
            return Stream.empty(); // Пропускаем проблемный файл
        }
    })
    .collect(Collectors.toList());
```

---

### 2. **Обертка для исключений (преобразование в RuntimeException)**
Создайте вспомогательный метод, который преобразует проверяемые исключения в непроверяемые.

```java
@FunctionalInterface
public interface ThrowingFunction<T, R> {
    R apply(T t) throws Exception;
}

public static <T, R> Function<T, R> wrap(ThrowingFunction<T, R> function) {
    return t -> {
        try {
            return function.apply(t);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };
}

// Использование
List<String> lines = fileNames.stream()
    .flatMap(wrap(fileName -> Files.lines(Paths.get(fileName))))
    .collect(Collectors.toList());
```

---

### 3. **Использование Optional для обработки ошибок**
Возвращайте `Optional` в операциях и фильтруйте пустые значения.

```java
List<String> validData = fileNames.stream()
    .map(fileName -> {
        try {
            return Optional.of(Files.readString(Paths.get(fileName)));
        } catch (IOException e) {
            return Optional.<String>empty();
        }
    })
    .filter(Optional::isPresent)
    .map(Optional::get)
    .collect(Collectors.toList());
```

---

### 4. **Сбор ошибок в отдельный список**
Создайте коллектор для накопления исключений во время обработки.

```java
class Result<T> {
    private T data;
    private Exception error;
    // Геттеры/сеттеры
}

List<Result<String>> results = fileNames.stream()
    .map(fileName -> {
        Result<String> result = new Result<>();
        try {
            result.setData(Files.readString(Paths.get(fileName)));
        } catch (IOException e) {
            result.setError(e);
        }
        return result;
    })
    .collect(Collectors.toList());

// Отдельно обработайте данные и ошибки
results.forEach(r -> {
    if (r.getError() != null) {
        System.err.println("Ошибка: " + r.getError().getMessage());
    } else {
        System.out.println(r.getData());
    }
});
```

---

### 5. **Использование библиотек**
Библиотеки вроде **Vavr** или **StreamEx** предоставляют встроенные методы для обработки исключений.

Пример с **Vavr**:
```java
List<String> lines = fileNames.stream()
    .flatMap(fileName -> Try.of(() -> Files.lines(Paths.get(fileName)))
        .onFailure(e -> System.err.println("Ошибка: " + e.getMessage()))
        .getOrElse(Stream.empty())
    )
    .collect(Collectors.toList());
```

---

### 6. **Обработка исключений в терминальных операциях**
Можно перехватывать `RuntimeException` после выполнения стрима.

```java
try {
    fileNames.stream()
        .flatMap(wrap(fileName -> Files.lines(Paths.get(fileName))))
        .forEach(System.out::println);
} catch (RuntimeException e) {
    if (e.getCause() instanceof IOException) {
        System.err.println("Ошибка ввода-вывода: " + e.getCause().getMessage());
    }
}
```

---

### Основные проблемы и решения:
| Проблема                          | Решение                                                                 |
|-----------------------------------|-------------------------------------------------------------------------|
| Проверяемые исключения в лямбдах  | Использовать `try-catch` внутри лямбды или обертку для исключений.      |
| Потеря информации об ошибках      | Собирать ошибки в отдельную коллекцию.                                 |
| Исключения в параллельных стримах | Убедиться, что обработка потокобезопасна (например, синхронизация).    |

---

### Итог:
- Для простых случаев: **`try-catch` внутри лямбды**.
- Для повторяющихся операций: **обертка исключений**.
- Для сложных сценариев: **сбор ошибок в коллекцию** или использование **библиотек**.

---
---
### 6. Как использовать методы фильтрации в Stream API, что принимает/возвращает?
В Java Stream API основным методом для фильтрации элементов является **`filter()`**. Он позволяет отбирать элементы потока по заданному условию. Вот подробное описание его работы и других связанных методов:

---

### **1. Метод `filter()`**
#### **Параметры:**
- Принимает **`Predicate<T>`** — функциональный интерфейс, который проверяет условие и возвращает `boolean`.  
  `Predicate<T>` имеет метод `test(T t)`, где `T` — тип элементов в потоке.

#### **Возвращаемое значение:**
- Возвращает **новый `Stream<T>`**, содержащий только элементы, удовлетворяющие условию.

#### **Пример:**
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

List<Integer> evenNumbers = numbers.stream()
    .filter(n -> n % 2 == 0)  // Predicate: проверка на четность
    .collect(Collectors.toList()); // [2, 4, 6]
```

---

### **2. Другие методы, связанные с фильтрацией**
#### **a) `distinct()`**
- **Параметры:** Не принимает аргументов.  
- **Возвращает:** `Stream<T>` с уникальными элементами (удаляет дубликаты через `equals()`).  
- **Пример:**  
  ```java
  List<String> words = Arrays.asList("Java", "java", "JAVA");
  List<String> unique = words.stream()
      .distinct() // Удалит дубликаты (с учетом регистра)
      .toList(); // ["Java", "java", "JAVA"]
  ```

#### **b) `limit(long n)`**
- **Параметры:** `n` — максимальное количество элементов в потоке.  
- **Возвращает:** `Stream<T>`, обрезанный до первых `n` элементов.  
- **Пример:**  
  ```java
  Stream.of(1, 2, 3, 4, 5)
      .limit(3) // Оставляет первые 3 элемента
      .forEach(System.out::print); // 123
  ```

#### **c) `skip(long n)`**
- **Параметры:** `n` — количество элементов, которые нужно пропустить.  
- **Возвращает:** `Stream<T>` без первых `n` элементов.  
- **Пример:**  
  ```java
  Stream.of(1, 2, 3, 4, 5)
      .skip(2) // Пропускает 1 и 2
      .forEach(System.out::print); // 345
  ```

---

### **3. Комбинирование фильтров**
Методы можно объединять в цепочки для сложных условий:
```java
List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Alex", "Ben");

List<String> filtered = names.stream()
    .filter(name -> name.startsWith("A")) // ["Alice", "Anna", "Alex"]
    .filter(name -> name.length() > 4)    // ["Alice", "Anna"]
    .toList();
```

---

### **4. Особенности работы**
- **Ленивые вычисления:** Фильтрация выполняется только при вызове терминальной операции (например, `collect()`).  
- **Порядок операций:** Важен! Например, `limit(3).filter(...)` может обработать меньше элементов, чем `filter(...).limit(3)`.  
- **Параллельные потоки:** Фильтрация работает корректно в многопоточном режиме (через `parallelStream()`).

---

### **5. Пример с обработкой объектов**
```java
class User {
    String name;
    int age;
    // Геттеры и конструктор
}

List<User> users = Arrays.asList(
    new User("Alice", 25),
    new User("Bob", 17),
    new User("Charlie", 30)
);

List<User> adults = users.stream()
    .filter(user -> user.getAge() >= 18) // Отфильтровать по возрасту
    .toList(); // Alice (25), Charlie (30)
```

---

### **6. Ошибки и подводные камни**
- **Null-элементы:** Если поток содержит `null`, фильтрация может вызвать `NullPointerException`. Решение:  
  ```java
  .filter(Objects::nonNull) // Игнорировать null-элементы
  ```
- **Сложные условия:** Избегайте побочных эффектов в `Predicate` (например, изменения внешних переменных).

---

### **Итог**
Метод `filter()` — это ключевой инструмент для отбора элементов в Stream API. Он принимает `Predicate<T>`, проверяет каждый элемент и возвращает новый поток. Комбинируя его с `distinct()`, `limit()`, `skip()` и другими методами, можно гибко управлять данными в функциональном стиле.

---
---
### 7. Как применять Collectors.groupingBy() Stream API, что принимает\возвращает?
Метод `Collectors.groupingBy()` в Java Stream API используется для группировки элементов потока по заданному критерию. Он возвращает `Collector`, который собирает элементы в `Map`, где ключи определяются классификатором, а значения — коллекцией элементов, соответствующих ключу. 

### Основные варианты метода:
1. **С одним параметром (классификатор)**:
   ```java
   Collectors.groupingBy(Function<? super T, ? extends K> classifier)
   ```
   - **Принимает**: Функцию-классификатор для определения ключей.
   - **Возвращает**: `Map<K, List<T>>`, где ключи — результат классификатора, значения — списки элементов.

   **Пример**:
   ```java
   List<String> words = Arrays.asList("apple", "banana", "cherry");
   Map<Integer, List<String>> wordsByLength = words.stream()
       .collect(Collectors.groupingBy(String::length));
   // Результат: {5=[apple], 6=[banana, cherry]}
   ```

2. **С двумя параметрами (классификатор и downstream-коллектор)**:
   ```java
   Collectors.groupingBy(
       Function<? super T, ? extends K> classifier,
       Collector<? super T, A, D> downstream
   )
   ```
   - **Принимает**: 
     - Классификатор.
     - Коллектор для обработки элементов группы (например, `Collectors.toSet()`, `Collectors.counting()`).
   - **Возвращает**: `Map<K, D>`, где `D` — тип, определяемый downstream-коллектором.

   **Пример**:
   ```java
   Map<Integer, Long> countByLength = words.stream()
       .collect(Collectors.groupingBy(String::length, Collectors.counting()));
   // Результат: {5=1, 6=2}
   ```

3. **С тремя параметрами (классификатор, supplier, downstream)**:
   ```java
   Collectors.groupingBy(
       Function<? super T, ? extends K> classifier,
       Supplier<Map<K, D>> mapSupplier,
       Collector<? super T, A, D> downstream
   )
   ```
   - **Принимает**: 
     - Классификатор.
     - Поставщик (`Supplier`) для создания нужного типа `Map` (например, `TreeMap::new`).
     - Downstream-коллектор.
   - **Возвращает**: Заданный тип `Map<K, D>`.

   **Пример**:
   ```java
   TreeMap<Integer, List<String>> sortedMap = words.stream()
       .collect(Collectors.groupingBy(
           String::length,
           TreeMap::new,
           Collectors.toList()
       ));
   // Результат: TreeMap с ключами 5 и 6
   ```

### Важные нюансы:
- По умолчанию используется `HashMap` и `Collectors.toList()`.
- Для преобразования элементов группы используйте `Collectors.mapping()`:
  ```java
  Map<Integer, List<Character>> firstLettersByLength = words.stream()
      .collect(Collectors.groupingBy(
          String::length,
          Collectors.mapping(s -> s.charAt(0), Collectors.toList())
      ));
  // Результат: {5=[a], 6=[b, c]}
  ```

### Итог:
- **Что принимает**: Функцию-классификатор, опционально тип `Map` и коллектор для обработки групп.
- **Что возвращает**: `Collector`, собирающий данные в `Map` с заданной структурой.

Метод `groupingBy()` обеспечивает гибкую группировку данных в потоках, позволяя реализовать сложные сценарии агрегации.

---
---
### 8. Как можно использовать Stream API для преобразования одного типа данных в другой, например int[] 1,2,3?
Для преобразования данных с использованием Stream API в Java, например, из `int[]` в другой тип, можно использовать следующие подходы:

---

### 1. **`int[]` → `List<Integer>`**
```java
int[] arr = {1, 2, 3};
List<Integer> list = Arrays.stream(arr) // IntStream
    .boxed() // Stream<Integer>
    .collect(Collectors.toList());
// Результат: [1, 2, 3]
```

---

### 2. **`int[]` → `Integer[]`**
```java
Integer[] integerArray = Arrays.stream(arr)
    .boxed()
    .toArray(Integer[]::new);
// Результат: Integer[] {1, 2, 3}
```

---

### 3. **`int[]` → `String`**
```java
String joinedString = Arrays.stream(arr)
    .mapToObj(String::valueOf) // Stream<String>
    .collect(Collectors.joining(", "));
// Результат: "1, 2, 3"
```

---

### 4. **`int[]` → `Set<Long>`**
```java
Set<Long> longSet = Arrays.stream(arr)
    .mapToLong(i -> (long) i) // LongStream
    .boxed() // Stream<Long>
    .collect(Collectors.toSet());
// Результат: Set<Long> {1L, 2L, 3L}
```

---

### 5. **`int[]` → `Map<Integer, String>`**
Преобразовать каждый элемент в ключ, добавив к нему строку:
```java
Map<Integer, String> map = Arrays.stream(arr)
    .boxed()
    .collect(Collectors.toMap(
        key -> key, 
        val -> "Value: " + val
    ));
// Результат: {1="Value: 1", 2="Value: 2", 3="Value: 3"}
```

---

### 6. **`int[]` → `double[]`**
```java
double[] doubles = Arrays.stream(arr)
    .mapToDouble(i -> (double) i) // DoubleStream
    .toArray();
// Результат: double[] {1.0, 2.0, 3.0}
```

---

### 7. **`int[]` → Фильтрация и преобразование**
Например, выбрать только четные числа и преобразовать их в строки:
```java
List<String> evenStrings = Arrays.stream(arr)
    .filter(i -> i % 2 == 0)
    .mapToObj(i -> "Число: " + i)
    .collect(Collectors.toList());
// Результат: ["Число: 2"]
```

---

### Ключевые методы Stream API:
- **`Arrays.stream(int[])`** → Создает `IntStream` из массива.
- **`boxed()`** → Преобразует примитивный поток (`IntStream`, `LongStream`, `DoubleStream`) в `Stream<Объект>` (например, `Stream<Integer>`).
- **`mapToObj()`** → Преобразует элементы потока в другой тип.
- **`collect(Collectors.toList())`** → Собирает элементы в коллекцию.
- **`toArray()`** → Преобразует поток в массив.

---

### Особенности работы с примитивами:
- Для примитивных типов (`int`, `long`, `double`) используйте:
  - `IntStream`, `LongStream`, `DoubleStream`.
  - Методы `mapToInt()`, `mapToLong()`, `mapToDouble()`.
- Для преобразования в объектные типы (`Integer`, `Long`, `Double`) применяйте `boxed()`.

---

### Пример полного кода:
```java
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        // 1. int[] → List<Integer>
        List<Integer> list = Arrays.stream(arr).boxed().toList();

        // 2. int[] → String
        String str = Arrays.stream(arr)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(", "));

        System.out.println(list); // [1, 2, 3]
        System.out.println(str);  // 1, 2, 3
    }
}
```

Stream API предоставляет гибкие инструменты для преобразования данных между типами с минимальным кодом.

---
---
### 9. Отличия flatMap от map
Основное отличие между `map()` и `flatMap()` в Java Stream API заключается в том, как они обрабатывают элементы потока:

---

### 1. **`map()`**  
- **Что делает**:  
  Применяет функцию к каждому элементу потока и возвращает поток результатов.  
  Каждый элемент преобразуется **в один новый элемент** (или `null`).  

- **Пример**:  
  ```java
  List<String> words = Arrays.asList("apple", "banana");
  List<Integer> lengths = words.stream()
      .map(String::length) // преобразует каждую строку в её длину (int)
      .collect(Collectors.toList());
  // Результат: [5, 6]
  ```

---

### 2. **`flatMap()`**  
- **Что делает**:  
  Применяет функцию, которая возвращает **поток** (Stream) для каждого элемента, а затем объединяет все потоки в один.  
  Позволяет "разгладить" вложенные структуры (например, списки списков).  

- **Пример**:  
  ```java
  List<List<String>> nestedList = Arrays.asList(
      Arrays.asList("a", "b"),
      Arrays.asList("c", "d")
  );

  List<String> flatList = nestedList.stream()
      .flatMap(Collection::stream) // преобразует List<String> в Stream<String>
      .collect(Collectors.toList());
  // Результат: [a, b, c, d]
  ```

---

### Ключевые отличия:
| **Критерий**          | **`map()`**                          | **`flatMap()`**                      |
|-----------------------|--------------------------------------|---------------------------------------|
| **Возвращаемый тип**  | `Stream<R>` (один элемент)           | `Stream<R>` (множество элементов)     |
| **Использование**     | Простое преобразование элемента      | Работа с вложенными структурами       |
| **Результат**         | Поток того же размера                | Поток может быть больше/меньше исходного |

---

### Примеры использования:
#### a) **`map()` для преобразования элемента в другой тип**  
```java
List<String> names = Arrays.asList("John", "Alice");
List<Integer> nameLengths = names.stream()
    .map(String::length) // String → int
    .collect(Collectors.toList()); // [4, 5]
```

#### b) **`flatMap()` для разворачивания вложенных данных**  
```java
List<String> sentences = Arrays.asList("Hello world", "Java Streams");
List<String> words = sentences.stream()
    .flatMap(s -> Arrays.stream(s.split(" "))) // разбиваем строку на слова
    .collect(Collectors.toList()); // [Hello, world, Java, Streams]
```

#### c) **`flatMap()` с Optional**  
```java
Optional<Optional<String>> nestedOptional = Optional.of(Optional.of("value"));
Optional<String> flatOptional = nestedOptional
    .flatMap(opt -> opt); // "разворачивает" Optional<Optional<T>> в Optional<T>
```

---

### Когда использовать:
- **`map()`**:  
  Когда нужно преобразовать каждый элемент в другой объект (например, `String` → `Integer`).  

- **`flatMap()`**:  
  - Когда элемент может быть преобразован в несколько элементов (например, разбиение строки на слова).  
  - Для работы с вложенными структурами (списки списков, `Optional<Optional<T>>`).  
  - Если функция возвращает `Stream`, и нужно объединить результаты.

---

### Итог:
- **`map()`** → 1 элемент → 1 элемент.  
- **`flatMap()`** → 1 элемент → много элементов (или ноль) → объединяет их в один поток.

---
---
### 10. Как работать с параллельными потоками с помощью Stream API?
Работа с параллельными потоками в Java Stream API позволяет задействовать несколько ядер процессора для ускорения обработки данных. Однако важно использовать их правильно, чтобы избежать ошибок и получить реальный прирост производительности. Вот основные аспекты:

---

### 1. **Создание параллельного потока**
#### a) Из коллекции:
```java
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
list.parallelStream() // создание параллельного потока
    .forEach(System.out::println);
```

#### b) Из обычного потока:
```java
Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
stream.parallel() // преобразование в параллельный
      .forEach(System.out::println);
```

---

### 2. **Когда использовать параллельные потоки**
- **Большие объемы данных**: Обычно выгода заметна при обработке десятков тысяч элементов.
- **Тяжелые вычисления**: Если операции над элементами требуют значительных ресурсов (например, математические расчеты).
- **Независимые операции**: Элементы можно обрабатывать независимо друг от друга.

---

### 3. **Особенности работы**
#### a) **Порядок элементов**
Параллельные потоки **не гарантируют порядок** выполнения операций. Например:
```java
List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
list.parallelStream()
    .forEach(n -> System.out.print(n + " ")); // Вывод может быть: 3 5 1 2 4
```

Для сохранения порядка используйте `forEachOrdered()`:
```java
list.parallelStream()
    .forEachOrdered(n -> System.out.print(n + " ")); // 1 2 3 4 5
```

#### b) **Потокобезопасность**
- **Статус функций**: Лямбда-выражения и функции должны быть **без состояния** (не изменять внешние переменные).
- **Общие ресурсы**: Избегайте использования несинхронизированных общих данных.

#### Пример ошибки (гонка данных):
```java
int[] sum = {0};
IntStream.range(0, 1000)
    .parallel()
    .forEach(i -> sum[0] += i); // Непотокобезопасно!
System.out.println(sum[0]); // Результат может быть некорректным
```

**Решение**: Используйте потокобезопасные операции (например, `reduce()`):
```java
int sum = IntStream.range(0, 1000)
    .parallel()
    .sum(); // Корректный результат
```

---

### 4. **Операции, эффективные в параллельных потоках**
- **Сокращающие операции**: `reduce()`, `collect()`, `sum()`, `min()`, `max()`.
- **Фильтрация и преобразование**: `filter()`, `map()`, `flatMap()` (если функции "чистые").
- **Параллельная сортировка**:
  ```java
  List<Integer> sortedList = list.parallelStream()
      .sorted()
      .collect(Collectors.toList());
  ```

---

### 5. **Подводные камни**
- **Накладные расходы**: Создание потоков и синхронизация могут замедлить выполнение для малых данных.
- **Ошибки в лямбда-выражениях**: Непотокобезопасный код может привести к `ConcurrentModificationException` или некорректным результатам.
- **Зависимость от порядка**: Операции вроде `limit()` или `findFirst()` могут работать медленнее в параллельных потоках.

---

### 6. **Пример: Сравнение производительности**
```java
List<Integer> numbers = IntStream.range(0, 10_000_000).boxed().toList();

// Последовательный поток
long start = System.currentTimeMillis();
numbers.stream().map(n -> n * 2).count();
long seqTime = System.currentTimeMillis() - start;

// Параллельный поток
start = System.currentTimeMillis();
numbers.parallelStream().map(n -> n * 2).count();
long parTime = System.currentTimeMillis() - start;

System.out.println("Последовательно: " + seqTime + " мс");
System.out.println("Параллельно: " + parTime + " мс");
```

**Результат** (зависит от железа):
```
Последовательно: 120 мс
Параллельно: 45 мс
```

---

### 7. **Лучшие практики**
1. **Измеряйте производительность**: Всегда проверяйте, дает ли параллелизм выгоду.
2. **Избегайте изменяемого состояния**: Используйте иммутабельные объекты и чистые функции.
3. **Выбирайте правильные структуры данных**: `ArrayList` работает быстрее в параллельных потоках, чем `LinkedList`.
4. **Используйте потокобезопасные коллекторы**:
   ```java
   Map<Integer, List<String>> map = list.parallelStream()
       .collect(Collectors.groupingByConcurrent(String::length));
   ```

---

### Итог:
Параллельные потоки — мощный инструмент, но их стоит применять осторожно. Используйте их для ресурсоемких задач с большими данными, избегайте общих изменяемых состояний и всегда проверяйте результат на корректность.

---
---
### 11. Как использовать метод forEach в Stream API? - что принимает\возвращает?
Метод `forEach()` в Java Stream API используется для выполнения действия над каждым элементом потока. Вот ключевые аспекты его работы:

---

### **1. Сигнатура метода**
```java
void forEach(Consumer<? super T> action)
```

---

### **2. Что принимает**
- **Параметр**: Функцию-потребитель (`Consumer`), которая принимает элемент потока и **не возвращает результат** (void).
- **Примеры**:
  ```java
  // Лямбда-выражение
  stream.forEach(e -> System.out.println(e));
  
  // Ссылка на метод
  stream.forEach(System.out::println);
  ```

---

### **3. Что возвращает**
- **Ничего** (`void`). Это терминальная операция — после её вызова поток нельзя переиспользовать.

---

### **4. Особенности**
#### a) **Порядок выполнения**
- **В последовательных потоках** элементы обрабатываются **в порядке их следования**.
- **В параллельных потоках** порядок **не гарантируется**.

#### b) **Параллелизм**
Пример с параллельным потоком:
```java
List.of("A", "B", "C").parallelStream()
    .forEach(e -> System.out.print(e + " ")); 
// Вывод может быть: C A B
```

#### c) **Потокобезопасность**
- Если используется общий ресурс (например, внешняя переменная), нужна синхронизация:
  ```java
  List<Integer> result = Collections.synchronizedList(new ArrayList<>());
  stream.parallel().forEach(e -> result.add(e)); // Безопасно
  ```

---

### **5. Когда использовать**
- Для побочных эффектов (логирование, сохранение в файл, модификация внешних переменных).
- Когда не требуется возвращать результат обработки потока.

---

### **6. Примеры**
#### a) Простой вывод элементов:
```java
List.of(1, 2, 3).stream()
    .forEach(n -> System.out.println(n * 10));
// Результат: 10, 20, 30
```

#### b) Изменение внешней переменной (осторожно!):
```java
StringBuilder sb = new StringBuilder();
List.of("a", "b", "c").stream()
    .forEach(sb::append);
System.out.println(sb); // "abc"
```

#### c) С параллельным потоком:
```java
List.of(1, 2, 3, 4).parallelStream()
    .forEach(n -> System.out.print(n + " "));
// Вывод может быть: 3 4 1 2
```

---

### **7. `forEachOrdered()`**
Если нужно сохранить порядок элементов **в параллельных потоках**:
```java
List.of(1, 2, 3, 4).parallelStream()
    .forEachOrdered(n -> System.out.print(n + " "));
// Вывод всегда: 1 2 3 4
```

---

### **8. Ограничения**
- **Нельзя использовать для модификации источника данных** (например, удаление элементов коллекции внутри `forEach` может вызвать `ConcurrentModificationException`).
- **Не подходит для преобразования данных** — для этого используйте `map()` + `collect()`:
  ```java
  // Неправильно:
  List<Integer> list = new ArrayList<>();
  stream.forEach(e -> list.add(e * 2)); // Риск при параллелизме
  
  // Правильно:
  List<Integer> result = stream.map(e -> e * 2).toList();
  ```

---

### **Итог**
Метод `forEach()` — это инструмент для выполнения действий над элементами потока без возврата результата. Используйте его для:
- Логирования,
- Сохранения данных,
- Вызова методов с побочными эффектами.

Для преобразования данных или фильтрации выбирайте другие операции Stream API: `map()`, `filter()`, `collect()`.

---
---
### 12. Как использовать метод peek в Stream API? - что принимает\возвращает?
Метод `peek()` в Java Stream API используется для промежуточной проверки элементов потока без изменения их состояния. Он часто применяется для отладки или логирования. Вот детали:

---

### **1. Сигнатура метода**
```java
Stream<T> peek(Consumer<? super T> action)
```

---

### **2. Что принимает**
- **Параметр**: Функцию-потребитель (`Consumer`), которая принимает элемент потока и **не возвращает результат** (void).
- **Примеры**:
  ```java
  // Лямбда-выражение
  .peek(e -> System.out.println("Элемент: " + e))
  
  // Ссылка на метод
  .peek(System.out::println)
  ```

---

### **3. Что возвращает**
- **Новый поток (`Stream<T>`)**: Это **промежуточная операция**, поэтому метод можно встраивать в цепочку вызовов. Поток остается открытым для дальнейших операций.

---

### **4. Примеры использования**
#### a) Отладка элементов перед фильтрацией:
```java
List<String> result = Stream.of("apple", "banana", "cherry")
    .peek(s -> System.out.println("До фильтра: " + s)) // Печать элементов
    .filter(s -> s.length() > 5)
    .peek(s -> System.out.println("После фильтра: " + s)) // Печать отфильтрованных
    .toList();

// Вывод:
// До фильтра: apple
// До фильтра: banana
// До фильтра: cherry
// После фильтра: banana
// После фильтра: cherry
```

#### b) Логирование модификаций:
```java
List<Integer> numbers = Arrays.asList(1, 2, 3);
List<Integer> doubled = numbers.stream()
    .peek(n -> System.out.println("Исходное: " + n))
    .map(n -> n * 2)
    .peek(n -> System.out.println("Удвоенное: " + n))
    .toList();
```

---

### **5. Особенности и предупреждения**
- **Ленивое выполнение**: `peek()` сработает только при вызове **терминальной операции** (например, `collect()`, `forEach()`).
  ```java
  // Без терминальной операции peek() не выполнится:
  Stream.of(1, 2, 3).peek(System.out::println); // Ничего не выведет!
  ```

- **Не для модификации данных**: 
  - `peek()` предназначен для наблюдения, а не изменения элементов.
  - Изменение состояний элементов может привести к ошибкам, особенно в параллельных потоках.

- **Порядок выполнения**:
  - В последовательных потоках порядок гарантирован.
  - В параллельных — порядок элементов не сохраняется.

---

### **6. Отличия от `forEach()`**
| **Критерий**          | **`peek()`**                          | **`forEach()`**                     |
|-----------------------|---------------------------------------|-------------------------------------|
| **Тип операции**      | Промежуточная                         | Терминальная                        |
| **Возвращаемое значение** | `Stream<T>` (поток)               | `void`                              |
| **Использование**     | В цепочке операций                    | В конце обработки                   |
| **Побочные эффекты**  | Не рекомендуется для изменений        | Часто используется для побочных эффектов |

---

### **7. Когда использовать `peek()`**
- **Отладка**: Проверка элементов на определенном этапе обработки.
- **Логирование**: Запись промежуточных результатов.
- **Анализ**: Визуализация данных в потоке без прерывания цепочки.

---

### **8. Антипаттерны**
- **Модификация элементов** (рискованно!):
  ```java
  List<String> list = new ArrayList<>();
  Stream.of("a", "b", "c")
      .peek(s -> list.add(s)) // Так можно, но лучше использовать .collect()
      .toList();
  ```
  - Предпочтительнее: `collect(Collectors.toList())`.

- **Использование в продакшн-коде** для критически важных операций — вместо `peek()` выбирайте явные методы (`map()`, `filter()`).

---

### Итог
Метод `peek()` — это инструмент для наблюдения за элементами потока **на промежуточных этапах**. Используйте его для отладки и логирования, но избегайте модификации данных. Для преобразования элементов применяйте `map()`, а для завершения обработки — терминальные операции (`forEach()`, `collect()`).

---
---
### 13. Как работает метод reduce в Stream API? - что принимает\возвращает? Варианты методы
Метод `reduce()` в Java Stream API используется для **свертки элементов потока в единое значение** (например, сумму, произведение, конкатенацию). Это терминальная операция, которая применяет функцию к элементам потока последовательно или параллельно. Рассмотрим все варианты метода.

---

### **1. Основные варианты `reduce()`**

#### **1.1. `Optional<T> reduce(BinaryOperator<T> accumulator)`**
- **Принимает**: `BinaryOperator<T>` — функция, объединяющая два элемента.
- **Возвращает**: `Optional<T>` (пустой, если поток пуст).
- **Пример**: Сумма чисел.
  ```java
  List<Integer> numbers = List.of(1, 2, 3, 4);
  Optional<Integer> sum = numbers.stream()
      .reduce((a, b) -> a + b);
  System.out.println(sum.get()); // 10
  ```

---

#### **1.2. `T reduce(T identity, BinaryOperator<T> accumulator)`**
- **Принимает**:
  - `identity` — начальное значение.
  - `BinaryOperator<T>` — функция объединения.
- **Возвращает**: `T` (результат свертки, гарантированно не `null`).
- **Пример**: Сумма с начальным значением.
  ```java
  int sum = numbers.stream()
      .reduce(0, (a, b) -> a + b); // identity = 0
  System.out.println(sum); // 10
  ```

---

#### **1.3. `<U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner)`**
- **Принимает**:
  - `identity` — начальное значение.
  - `accumulator` — функция для объединения промежуточного результата с элементом.
  - `combiner` — функция для объединения результатов параллельных вычислений.
- **Возвращает**: `U` (финальный результат).
- **Пример**: Конкатенация строк в параллельном потоке.
  ```java
  List<String> words = List.of("Hello", "world", "!");
  String result = words.parallelStream()
      .reduce(
          "", // identity
          (partial, str) -> partial + str, // accumulator
          (s1, s2) -> s1 + s2 // combiner (может быть заменен String::concat)
      );
  System.out.println(result); // Helloworld!
  ```

---

### **2. Особенности работы**
#### **2.1. Для параллельных потоков**:
- **Аккумулятор и комбайнер** должны быть:
  - **Ассоциативными**: `(a op b) op c == a op (b op c)`.
  - **Без побочных эффектов**: Не менять внешнее состояние.
- **Пример ошибки**: Использование неассоциативной операции (например, вычитания):
  ```java
  // Неправильно для параллелизма:
  numbers.parallelStream().reduce(0, (a, b) -> a - b);
  ```

---

#### **2.2. Identity-значение**:
- Должно быть **нейтральным элементом** для операции (например, `0` для сложения, `1` для умножения).
  ```java
  int product = numbers.stream()
      .reduce(1, (a, b) -> a * b); // identity = 1
  ```

---

### **3. Примеры использования**
#### **3.1. Поиск максимального элемента**:
```java
Optional<Integer> max = numbers.stream()
    .reduce(Integer::max);
System.out.println(max.get()); // 4
```

---

#### **3.2. Конкатенация строк**:
```java
List<String> list = List.of("a", "b", "c");
String concat = list.stream()
    .reduce("", (s1, s2) -> s1 + s2);
System.out.println(concat); // "abc"
```

---

#### **3.3. Сумма длин строк**:
```java
int totalLength = list.stream()
    .reduce(0, 
        (sum, s) -> sum + s.length(), // аккумулятор
        Integer::sum // комбайнер (для параллелизма)
    );
System.out.println(totalLength); // 3 (a + b + c)
```

---

### **4. Сравнение с `collect()`**
| **Критерий**       | **`reduce()`**                          | **`collect()`**                     |
|--------------------|-----------------------------------------|--------------------------------------|
| **Изменяемость**   | Работает с **неизменяемыми** данными    | Работает с **изменяемыми** контейнерами (например, `ArrayList`) |
| **Побочные эффекты** | Не рекомендуется                        | Разрешает (например, добавление в коллекцию) |
| **Пример**         | Сумма, произведение                     | Сбор элементов в `List`, `Map`       |

---

### **5. Лучшие практики**
1. **Используйте специализированные методы** для примитивов:
   ```java
   int sum = IntStream.range(1, 5).sum(); // Быстрее, чем reduce()
   ```
2. **Избегайте `reduce()` для изменяемых данных** — вместо этого используйте `collect()`:
   ```java
   // Неправильно:
   List<String> badList = new ArrayList<>();
   stream.reduce(badList, (list, e) -> { list.add(e); return list; }, List::addAll);
   
   // Правильно:
   List<String> goodList = stream.collect(Collectors.toList());
   ```
3. **Проверяйте ассоциативность** операций для параллельных потоков.

---

### **Итог**
Метод `reduce()` — мощный инструмент для агрегации элементов потока. Используйте его для:
- Математических операций (сумма, произведение).
- Конкатенации строк.
- Свертки данных в пользовательские структуры.

Для изменяемых операций (например, сбор в коллекцию) предпочтительнее `collect()`, а для примитивов — методы вроде `sum()`, `min()`, `max()`.

---
---
### 14. Как создать бесконечный поток с помощью Stream API?
Для создания бесконечного потока в Java с использованием Stream API можно воспользоваться методами `generate()` и `iterate()`. Вот примеры реализации:

### 1. Использование `Stream.generate()`
Этот метод принимает `Supplier<T>`, который поставляет новые элементы.

```java
import java.util.stream.Stream;

public class InfiniteStreamExample {
    public static void main(String[] args) {
        // Бесконечный поток констант
        Stream<String> infiniteHello = Stream.generate(() -> "Hello");
        infiniteHello.limit(5).forEach(System.out::println); // Ограничиваем вывод 5 элементами

        // Бесконечный поток случайных чисел
        Stream<Double> randomNumbers = Stream.generate(Math::random);
        randomNumbers.limit(3).forEach(System.out::println);
    }
}
```

### 2. Использование `Stream.iterate()`
Этот метод создаёт последовательность, применяя функцию к предыдущему элементу.

```java
import java.util.stream.Stream;

public class InfiniteStreamExample {
    public static void main(String[] args) {
        // Бесконечная последовательность чисел, начиная с 0
        Stream<Integer> numbers = Stream.iterate(0, n -> n + 1);
        numbers.limit(10).forEach(System.out::println); // Выведет 0, 1, 2, ..., 9

        // Пример с начальным значением и шагом (Java 9+)
        Stream.iterate(0, n -> n < 100, n -> n + 1) // Конечный поток (условие остановки)
              .forEach(System.out::println);
    }
}
```

### 3. Для примитивных типов
Используйте `IntStream`, `LongStream`, `DoubleStream`:

```java
import java.util.Random;
import java.util.stream.IntStream;

public class InfiniteStreamExample {
    public static void main(String[] args) {
        // Бесконечный поток целых чисел
        IntStream infiniteInts = IntStream.iterate(0, n -> n + 1);
        infiniteInts.limit(7).forEach(System.out::println);

        // Бесконечные случайные числа
        Random random = new Random();
        IntStream randomInts = random.ints(); // Аналогично для longs(), doubles()
        randomInts.limit(3).forEach(System.out::println);
    }
}
```

### Важные замечания:
- **Ограничение потока**: Используйте `limit(n)`, чтобы избежать бесконечного выполнения.
- **Терминальные операции**: Некоторые операции (например, `findFirst()`, `anyMatch()`) могут завершиться до обработки всех элементов.
- **Ленивая генерация**: Элементы создаются только тогда, когда это требуется терминальной операцией.

Пример с досрочным завершением:
```java
Stream<Integer> stream = Stream.iterate(0, n -> n + 1);
boolean hasEven = stream.anyMatch(n -> n % 2 == 0 && n > 10); // true, завершится при n=12
```

Таким образом, бесконечные потоки полезны для работы с последовательностями неизвестной длины или генерации данных "на лету".

---
---
### 15. Какие ограничения есть у Stream API?
Stream API в Java предоставляет удобный и мощный инструмент для работы с данными, но имеет ряд ограничений, о которых важно знать:

---

### 1. **Неизменяемость данных**
   - Стримы не модифицируют исходную коллекцию/источник данных. Они обрабатывают элементы и возвращают новый поток.
   ```java
   List<Integer> list = new ArrayList<>(List.of(1, 2, 3));
   list.stream().map(n -> n * 2).forEach(System.out::println); // 2, 4, 6
   // list остаётся [1, 2, 3]
   ```

---

### 2. **Однократное использование**
   - После вызова терминальной операции (например, `forEach`, `collect`) поток нельзя использовать повторно.
   ```java
   Stream<Integer> stream = Stream.of(1, 2, 3);
   stream.forEach(System.out::println); // OK
   stream.forEach(System.out::println); // Ошибка: поток уже закрыт
   ```

---

### 3. **Ограничения в параллелизме**
   - Не все операции безопасны в параллельных стримах (например, использование неатомарных переменных).
   - Порядок элементов может нарушаться в параллельном режиме, если не указано `forEachOrdered`.
   ```java
   List<Integer> list = List.of(1, 2, 3, 4);
   list.parallelStream()
       .forEach(n -> System.out.print(n + " ")); // Порядок вывода не гарантирован
   ```

---

### 4. **Сложности с отладкой**
   - Точки останова внутри лямбда-выражений трудно отслеживать в отладчиках.
   - Цепочки стримов могут усложнять чтение стека вызовов.

---

### 5. **Ограничения по производительности**
   - Для простых операций (например, обход небольшой коллекции) стримы могут быть медленнее традиционных циклов из-за накладных расходов.
   - Параллельные стримы не всегда ускоряют выполнение (например, при синхронизации или малом объеме данных).

---

### 6. **Проблемы с исключениями**
   - Лямбды в стримах не поддерживают проверяемые исключения (`checked exceptions`). Их нужно обрабатывать внутри или оборачивать в `RuntimeException`.
   ```java
   List<String> files = List.of("file1.txt", "file2.txt");
   files.stream()
        .map(name -> {
            try {
                return new FileInputStream(name);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        })
        .forEach(...);
   ```

---

### 7. **Ограничения примитивных стримов**
   - Существуют только `IntStream`, `LongStream`, `DoubleStream`. Для других примитивов (например, `char`, `byte`) приходится использовать боксинг.
   ```java
   "abcde".chars() // Возвращает IntStream (коды символов)
          .map(c -> (char) c) // Боксинг в char
          .forEach(System.out::println);
   ```

---

### 8. **Бесконечные стримы требуют осторожности**
   - Без использования `limit()`, `findFirst()` и других ограничивающих операций терминальные методы (например, `collect()`, `forEach()`) могут не завершиться.
   ```java
   Stream.generate(() -> "data")
        .forEach(System.out::println); // Бесконечный цикл!
   ```

---

### 9. **Невозможность использования break/return**
   - В стримах нельзя прервать обработку с помощью `break` или `return` (как в циклах). Для этого используются методы `takeWhile`, `filter` или `limit`.
   ```java
   Stream.iterate(0, n -> n + 1)
         .takeWhile(n -> n < 10) // Java 9+
         .forEach(System.out::println);
   ```

---

### 10. **Ограничения в работе с состоянием**
   - Операции в стримах должны быть **без состояния** (stateless), чтобы избежать ошибок в параллельном режиме.
   ```java
   // Неправильно: состояние изменяется внутри лямбды
   AtomicInteger counter = new AtomicInteger();
   Stream.of(1, 2, 3).parallel()
        .map(n -> n + counter.getAndIncrement()) // Результат непредсказуем
        .forEach(...);
   ```

---

### 11. **Сложности с несколькими источниками данных**
   - Объединение нескольких стримов требует использования `flatMap` или `concat`, что не всегда интуитивно.

---

### Когда использовать Stream API:
- Для обработки данных в декларативном стиле.
- Для работы с большими наборами данных и параллельной обработки.
- Когда требуется цепочка операций (фильтрация, преобразование, группировка).

### Когда избегать:
- В простых циклах с малым количеством элементов.
- Если нужны побочные эффекты (изменение переменных, I/O-операции).
- В случаях, где критична производительность на низком уровне.

Stream API — это мощный инструмент, но его стоит применять с учетом контекста и ограничений.

---
---
### 16. Как передать переменную в стрим что с ней можно сделать
В Java, чтобы использовать внешнюю переменную внутри Stream API, важно учитывать **ограничения лямбда-выражений** (например, требование effectively final). Вот как это можно сделать:

---

### 1. **Переменные для чтения (effectively final)**
Если переменная используется только для чтения, она должна быть **effectively final** (не изменяться после инициализации).

```java
List<String> names = List.of("Alice", "Bob", "Charlie");
String prefix = "Mr. "; // effectively final

List<String> processed = names.stream()
    .map(name -> prefix + name) // Чтение переменной
    .toList();

System.out.println(processed); // [Mr. Alice, Mr. Bob, Mr. Charlie]
```

---

### 2. **Изменение переменной внутри стрима**
Если нужно изменить переменную, используйте **обёртки** (например, массив или `Atomic`-классы).  
⚠️ **Важно**: Это может привести к проблемам в параллельных стримах!

#### Пример с массивом:
```java
int[] counter = {0}; // Используем массив для обхода ограничения effectively final

List<Integer> numbers = List.of(1, 2, 3, 4);
numbers.stream()
    .forEach(n -> {
        counter[0] += n; // Изменяем значение через массив
    });

System.out.println(counter[0]); // 10
```

#### Пример с `AtomicInteger` (потокобезопасно):
```java
AtomicInteger atomicCounter = new AtomicInteger(0);

List.of("a", "b", "c").stream()
    .forEach(s -> atomicCounter.incrementAndGet());

System.out.println(atomicCounter.get()); // 3
```

---

### 3. **Собирать результаты через `collect()`**
Лучшая практика — избегать изменения внешних переменных. Используйте аккумуляторы в `collect()`:

```java
List<Integer> numbers = List.of(1, 2, 3, 4);

// Сумма через collect()
int sum = numbers.stream()
    .collect(() -> new int[1], (acc, n) -> acc[0] += n, (acc1, acc2) -> acc1[0] += acc2[0])[0];

System.out.println(sum); // 10
```

Или проще с `reduce()`:
```java
int sum = numbers.stream()
    .reduce(0, Integer::sum);

System.out.println(sum); // 10
```

---

### 4. **Использование методов с состоянием (осторожно!)**
Некоторые операции (например, `peek()`) позволяют выполнять побочные эффекты, но это не рекомендуется:

```java
List<String> result = new ArrayList<>();

List.of("a", "b", "c").stream()
    .peek(result::add) // Нежелательный побочный эффект
    .forEach(System.out::println);

System.out.println(result); // [a, b, c]
```

---

### Ограничения и советы:
1. **Параллельные стримы**: Изменение общих переменных в параллельных стримах может вызвать состояние гонки. Используйте потокобезопасные структуры (например, `ConcurrentHashMap`, `AtomicInteger`).
2. **Чистые функции**: Старайтесь делать лямбды без побочных эффектов — это упрощает отладку и работу с параллелизмом.
3. **Альтернативы**: Если нужно сложное состояние, используйте `reduce()` или `collect()` с кастомными аккумуляторами.

---

### Пример: Подсчёт элементов по условию
```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);
long count = numbers.stream()
    .filter(n -> n % 2 == 0)
    .count(); // Нет необходимости вручную менять переменные!

System.out.println(count); // 2
```

**Итог**: Передавайте переменные через effectively final-ссылки или обёртки, но избегайте их модификации. Используйте встроенные операции Stream API (`collect`, `reduce`) для работы с состоянием.

---
---
### 17. Как создать Optional
В Java класс `Optional` используется для оборачивания значений, которые могут быть `null`, чтобы явно обрабатывать случай отсутствия данных. Вот основные способы создания объектов `Optional`:

---

### 1. **`Optional.of(T value)`**
Создает `Optional` с **ненулевым** значением. Если передать `null`, выбросит `NullPointerException`.

```java
Optional<String> nonNullOptional = Optional.of("Hello");
System.out.println(nonNullOptional.get()); // Hello

// Optional.of(null); // Выбросит NPE
```

**Когда использовать**: Когда значение гарантированно не `null`.

---

### 2. **`Optional.ofNullable(T value)`**
Создает `Optional`, который **может содержать `null`**. Если значение `null`, возвращает пустой `Optional`.

```java
String possibleNull = someMethod();
Optional<String> nullableOptional = Optional.ofNullable(possibleNull);

nullableOptional.ifPresentOrElse(
    val -> System.out.println("Значение: " + val),
    () -> System.out.println("Значение отсутствует")
);
```

**Когда использовать**: Когда значение может быть `null`.

---

### 3. **`Optional.empty()`**
Возвращает пустой `Optional` (аналог `null`, но безопасный).

```java
Optional<String> emptyOptional = Optional.empty();
System.out.println(emptyOptional.isPresent()); // false
```

**Когда использовать**: Когда нужно явно указать отсутствие значения.

---

### Примеры использования

#### Создание Optional из результата метода:
```java
public Optional<String> findUser(int id) {
    String user = database.getUserById(id);
    return Optional.ofNullable(user); // Возвращает Optional с user или empty
}
```

#### Обработка Optional:
```java
Optional<String> data = findUser(42);

// Проверка наличия значения
if (data.isPresent()) {
    System.out.println(data.get());
}

// Безопасное извлечение с дефолтным значением
String result = data.orElse("User not found");

// Ленивое вычисление дефолта
String result = data.orElseGet(() -> fetchDefaultUser());

// Выброс исключения, если значения нет
String result = data.orElseThrow(() -> new RuntimeException("User not found"));
```

---

### Важные правила:
1. **Не передавайте `null` в `Optional.of()`** — это приведет к `NullPointerException`.
2. **Не используйте `Optional` для полей классов, параметров методов или коллекций** — это антипаттерн.
3. **Всегда возвращайте `Optional.empty()` вместо `null`** из методов, возвращающих `Optional`.

---

### Лучшие практики:
- Используйте `Optional` для возвращаемых типов методов, где результат может отсутствовать.
- Избегайте цепочек вида `optional.get()` без проверки `isPresent()` — это может вызвать `NoSuchElementException`.
- Предпочитайте методы `orElse()`, `orElseGet()`, `ifPresent()` для безопасной работы.

Пример безопасной обработки:
```java
findUser(42)
    .map(String::toUpperCase)
    .ifPresent(System.out::println);
```

`Optional` помогает писать более чистый и безопасный код, минимизируя риски `NullPointerException`.

---
---
### 18. Отличие Optional of() nulable()
В Java методы `Optional.of()` и `Optional.ofNullable()` используются для создания объектов `Optional`, но они работают по-разному в зависимости от переданного значения. Вот ключевые отличия:

---

### 1. **`Optional.of(T value)`**
- **Назначение**: Создает `Optional` с **гарантированно не-null значением**.
- **Поведение**:
  - Если передать **не-null** значение — возвращает `Optional` с этим значением.
  - Если передать **`null`** — выбрасывает `NullPointerException`.
- **Когда использовать**: Когда вы уверены, что значение **не может быть `null`**.
- **Пример**:
  ```java
  String name = "Alice";
  Optional<String> optionalName = Optional.of(name); // OK

  // Optional.of(null); // Выбросит NullPointerException
  ```

---

### 2. **`Optional.ofNullable(T value)`**
- **Назначение**: Создает `Optional`, который **может содержать `null`**.
- **Поведение**:
  - Если передать **не-null** значение — возвращает `Optional` с этим значением.
  - Если передать **`null`** — возвращает **пустой `Optional`** (аналогично `Optional.empty()`).
- **Когда использовать**: Когда значение **может быть `null`**.
- **Пример**:
  ```java
  String name = someMethodThatMightReturnNull();
  Optional<String> optionalName = Optional.ofNullable(name); 
  
  // Если name == null, optionalName будет пустым.
  ```

---

### Сравнение в таблице

| Критерий               | `Optional.of()`                  | `Optional.ofNullable()`              |
|------------------------|----------------------------------|---------------------------------------|
| **Принимает `null`?**  | Нет (выбрасывает `NPE`)         | Да (возвращает пустой `Optional`)     |
| **Использование**       | Значение точно не `null`        | Значение может быть `null`            |
| **Пример**             | `Optional.of("Hello")`          | `Optional.ofNullable(getData())`      |

---

### Примеры обработки

#### С `Optional.of()`:
```java
String nonNullValue = "Hello";
Optional<String> opt = Optional.of(nonNullValue); // Гарантированно не пустой
System.out.println(opt.get()); // Hello
```

#### С `Optional.ofNullable()`:
```java
String maybeNull = someExternalCall();
Optional<String> opt = Optional.ofNullable(maybeNull);

// Безопасное извлечение
String result = opt.orElse("Default Value");
```

---

### Рекомендации
1. **`Optional.of()`**:
   - Используйте, если значение **точно не `null`** (например, литерал, результат проверенного метода).
   - Полезно для явного указания, что `null` недопустим.

2. **`Optional.ofNullable()`**:
   - Используйте, если значение **может быть `null`** (например, данные из БД, пользовательский ввод).
   - Часто сочетается с методами вроде `orElse()`, `orElseThrow()`, `ifPresent()`.

3. **Никогда не передавайте `null` в `Optional.of()`** — это нарушение контракта метода.

---

### Важно!
- **`Optional` не заменяет проверки на `null`**, а помогает структурировать код.
- Избегайте цепочек вроде `optional.get()` без проверки `isPresent()` — это может вызвать `NoSuchElementException`.
- Используйте `Optional` для возвращаемых значений методов, а не для параметров или полей класса.

---
---
### 19. В чем отличие методов ifPresent и orElse в контексте Optional?
В Java методы `ifPresent()` и `orElse()` у класса `Optional` служат разным целям и работают по-разному. Вот их ключевые отличия:

---

### **1. `ifPresent(Consumer<T> action)`**
- **Назначение**: Выполняет действие, если значение в `Optional` **присутствует**.
- **Возвращаемое значение**: `void` (ничего не возвращает).
- **Поведение**:
  - Если `Optional` **не пуст**, переданный `Consumer` выполняется с его значением.
  - Если `Optional` **пуст**, ничего не происходит.
- **Когда использовать**: Когда нужно выполнить побочный эффект (например, вывод в консоль, запись в лог) только при наличии значения.
- **Пример**:
  ```java
  Optional<String> name = Optional.of("Alice");
  name.ifPresent(n -> System.out.println("Имя: " + n)); // Выведет "Имя: Alice"

  Optional.empty().ifPresent(n -> System.out.println("Не выполнится"));
  ```

---

### **2. `orElse(T defaultValue)`**
- **Назначение**: Возвращает значение из `Optional`, если оно есть, или **значение по умолчанию**, если `Optional` пуст.
- **Возвращаемое значение**: `T` (значение из `Optional` или дефолтное).
- **Поведение**:
  - Если `Optional` **не пуст**, возвращает его значение.
  - Если `Optional` **пуст**, возвращает `defaultValue`.
- **Когда использовать**: Когда нужно гарантированно получить значение (даже если оно дефолтное).
- **Пример**:
  ```java
  Optional<String> name = Optional.of("Alice");
  String result1 = name.orElse("Unknown"); // "Alice"

  Optional<String> emptyName = Optional.empty();
  String result2 = emptyName.orElse("Unknown"); // "Unknown"
  ```

---

### **Сравнение в таблице**

| Критерий               | `ifPresent()`                          | `orElse()`                            |
|------------------------|----------------------------------------|---------------------------------------|
| **Возвращает значение** | Нет (`void`)                           | Да (`T`)                              |
| **Аргумент**           | `Consumer<T>` (действие)               | `T` (дефолтное значение)              |
| **Цель**               | Выполнить действие при наличии значения | Получить значение или дефолт          |
| **Пример использования** | Логирование, вызов метода           | Возврат резервного значения           |

---

### **Примеры для понимания**

#### Пример с `ifPresent()`:
```java
Optional<Integer> number = Optional.of(42);
number.ifPresent(n -> {
    System.out.println("Квадрат числа: " + n * n); // Выполнится: 1764
});

Optional.empty().ifPresent(n -> System.out.println("Не выполнится"));
```

#### Пример с `orElse()`:
```java
Optional<String> data = Optional.of("Hello");
String value1 = data.orElse("Default"); // "Hello"

Optional<String> emptyData = Optional.empty();
String value2 = emptyData.orElse("Default"); // "Default"
```

---

### **Важные нюансы**
1. **`orElse()` всегда вычисляется**:
   - Даже если `Optional` не пуст, аргумент `defaultValue` в `orElse()` **вычисляется заранее**. Это может быть неэффективно, если получение дефолта требует ресурсов. В таких случаях используйте `orElseGet(Supplier<T>)`, который вычисляет дефолт лениво:
     ```java
     String result = optionalValue.orElseGet(() -> expensiveOperation());
     ```

2. **`ifPresent()` не заменяет `orElse()`**:
   - `ifPresent()` не может вернуть значение. Если нужно и выполнить действие, и вернуть результат, используйте `map()` или `flatMap()`.

3. **Комбинирование методов**:
   - Для сложных сценариев можно объединять методы:
     ```java
     Optional.of("Alice")
         .filter(s -> s.length() > 3)
         .ifPresent(System.out::println); // "Alice"
     ```

---

### **Когда что использовать**
- **`ifPresent()`**:
  - Когда нужно выполнить действие только при наличии значения (например, обновить UI, отправить данные).
- **`orElse()`**:
  - Когда нужно гарантированно получить значение (например, вернуть результат из метода или установить дефолт для поля).

---

### **Советы**
- Избегайте цепочек вроде `optional.ifPresent(...).orElse(...)` — это невозможно, так как `ifPresent()` возвращает `void`.
- Для безопасного извлечения значения с обработкой всех случаев используйте:
  ```java
  optionalValue.ifPresentOrElse(
      value -> process(value),
      () -> handleEmpty()
  );
  ``` 
  (доступно с Java 9+).

---
---
### 20. Каким образом можно объединить два Optional в один, используя метод join?
Для объединения двух объектов `Optional` в Java стандартная библиотека не предоставляет метода с именем `join`, но вы можете достичь этого с помощью комбинации методов `flatMap` и `map`. Вот как это сделать:

---

### **1. Объединение двух Optional в новый Optional**
Если нужно объединить значения двух `Optional` **только если оба присутствуют**, используйте цепочку `flatMap` и `map`:

```java
Optional<String> opt1 = Optional.of("Hello");
Optional<Integer> opt2 = Optional.of(42);

Optional<String> result = opt1.flatMap(s -> 
    opt2.map(i -> s + " " + i) // Объединяем значения
);

System.out.println(result); // Optional[Hello 42]
```

Если хотя бы один из `Optional` пуст, результат будет `Optional.empty()`:

```java
Optional<String> emptyOpt = Optional.empty();
Optional<String> result = emptyOpt.flatMap(s -> opt2.map(i -> s + i));
System.out.println(result); // Optional.empty
```

---

### **2. Создание объекта-контейнера (например, пары)**
Если нужно сохранить оба значения в структуре данных (например, в классе-паре):

```java
// Пример класса-пары
public class Pair<A, B> {
    private final A first;
    private final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    // Геттеры и toString
}

// Объединение в Optional<Pair>
Optional<Pair<String, Integer>> pairResult = opt1.flatMap(s -> 
    opt2.map(i -> new Pair<>(s, i))
);

System.out.println(pairResult); // Optional[Pair{first=Hello, second=42}]
```

---

### **3. Использование кастомной функции для объединения**
Можно передать `BiFunction` для гибкого объединения значений:

```java
BiFunction<String, Integer, String> combineFunction = (s, i) -> s + " - " + i;

Optional<String> customResult = opt1.flatMap(s -> 
    opt2.map(i -> combineFunction.apply(s, i))
);

System.out.println(customResult); // Optional[Hello - 42]
```

---

### **4. Если нужно объединить Optional с разными типами**
Например, `Optional<String>` и `Optional<Integer>`:

```java
Optional<String> optA = Optional.of("Java");
Optional<Integer> optB = Optional.of(17);

Optional<String> combined = optA.flatMap(a -> 
    optB.map(b -> a + " " + b)
);

System.out.println(combined); // Optional[Java 17]
```

---

### **Почему нет метода `join`?**
В стандартной библиотеке Java нет метода `join` для `Optional`, но аналогичного поведения можно добиться через:
- `flatMap` — для обработки первого `Optional`,
- `map` — для преобразования значения второго `Optional`.

---

### **Альтернатива: Использование Stream API**
Можно преобразовать `Optional` в поток и объединить элементы:

```java
Optional<String> combinedStream = opt1.stream()
    .flatMap(s -> opt2.stream().map(i -> s + i))
    .findFirst();

System.out.println(combinedStream); // Optional[Hello42]
```

---

### **Итог**
Для объединения двух `Optional` в Java:
1. Используйте `flatMap` для первого `Optional`.
2. Внутри `flatMap` примените `map` ко второму `Optional`.
3. Создайте результат, комбинируя значения.

Этот подход гарантирует, что результат будет непустым **только если оба исходных `Optional` содержат значения**.

---
---
### 21. Что проверяет ifPresent Optional?
Метод `ifPresent()` у класса `Optional` в Java **проверяет, содержит ли `Optional` значение**, и если да — выполняет переданное действие (лямбда-выражение или метод). Если `Optional` пуст, действие игнорируется. 

### Как работает `ifPresent()`:
1. **Проверка наличия значения**: 
   - Если `Optional` **не пуст** (содержит не-null значение), выполняется переданный `Consumer`.
   - Если `Optional` **пуст** (значение `null` или создан через `Optional.empty()`), ничего не происходит.
2. **Возвращаемое значение**: `void` (метод ничего не возвращает).

---

### Примеры:

#### 1. **`Optional` с значением**:
```java
Optional<String> name = Optional.of("Alice");
name.ifPresent(n -> System.out.println("Имя: " + n)); 
// Выведет: "Имя: Alice"
```

#### 2. **Пустой `Optional`**:
```java
Optional<String> emptyName = Optional.empty();
emptyName.ifPresent(n -> System.out.println("Это не выполнится")); 
// Ничего не произойдет
```

#### 3. **Использование ссылки на метод**:
```java
Optional<List<String>> list = Optional.of(List.of("a", "b"));
list.ifPresent(System.out::println); 
// Выведет: [a, b]
```

---

### Сравнение с `isPresent()`:
- **`ifPresent()`**:
  - Принимает `Consumer<T>`.
  - **Выполняет действие**, если значение есть.
  ```java
  optionalValue.ifPresent(v -> process(v));
  ```

- **`isPresent()`**:
  - Возвращает `boolean`.
  - **Проверяет наличие значения**, но не выполняет действие.
  ```java
  if (optionalValue.isPresent()) {
      process(optionalValue.get());
  }
  ```

---

### Зачем использовать `ifPresent()`?
- **Удобство**: Избегает явных проверок через `if (value != null)`.
- **Безопасность**: Исключает риск `NullPointerException`.
- **Чистый код**: Работа в функциональном стиле.

---

### Пример замены традиционной проверки на `null`:
#### Без `Optional`:
```java
String name = getName(); // Может вернуть null
if (name != null) {
    System.out.println(name);
}
```

#### С `Optional`:
```java
Optional<String> nameOpt = Optional.ofNullable(getName());
nameOpt.ifPresent(n -> System.out.println(n));
```

---

### Важные нюансы:
- **Не вызывает исключений**: Если `Optional` пуст, метод просто ничего не делает.
- **Не возвращает значение**: Если нужно получить результат, используйте `orElse()`, `orElseGet()` или `orElseThrow()`.
- **Побочные эффекты**: `ifPresent()` предназначен для выполнения действий (логирование, сохранение и т.д.), а не для преобразования данных.

---

### Когда использовать:
- Когда нужно выполнить действие **только при наличии значения**.
- Для обработки данных внутри `Optional` без извлечения их наружу (например, передача в другой метод).

Метод `ifPresent()` — это безопасный и декларативный способ работы с потенциально отсутствующими значениями.

---
---
### 22. Каким образом можно преобразовать Stream в массив или коллекцию?
В Java Stream API преобразование потока (Stream) в массив или коллекцию выполняется с помощью **терминальных операций**. Вот основные способы:

---

### **1. Преобразование Stream в массив**
#### **a) Метод `toArray()`**
Возвращает массив типа `Object[]`:
```java
Stream<String> stream = Stream.of("A", "B", "C");
Object[] array = stream.toArray(); // Object[]: ["A", "B", "C"]
```

#### **b) Метод `toArray(IntFunction<A[]> generator)`**
Позволяет указать тип массива:
```java
String[] stringArray = stream.toArray(String[]::new); // String[]: ["A", "B", "C"]
```

---

### **2. Преобразование Stream в коллекцию**
#### **a) Стандартные коллекции через `Collectors`**
Используйте метод `collect()` с коллекторами:
```java
import java.util.stream.Collectors;

// В список (List)
List<String> list = stream.collect(Collectors.toList());

// В множество (Set)
Set<String> set = stream.collect(Collectors.toSet());

// В конкретную реализацию коллекции (например, LinkedList)
LinkedList<String> linkedList = stream.collect(Collectors.toCollection(LinkedList::new));
```

#### **b) Специальные коллекции**
```java
// В Map (например, ключ — строка, значение — длина строки)
Map<String, Integer> map = stream.collect(
    Collectors.toMap(s -> s, String::length) // s -> ключ, String::length -> значение
);

// Группировка (например, группировка по длине строки)
Map<Integer, List<String>> groupedByLength = stream.collect(
    Collectors.groupingBy(String::length)
);
```

---

### **Примеры**

#### **Stream → Массив**
```java
Stream<Integer> numberStream = Stream.of(10, 20, 30);

// Вариант 1: Object[]
Object[] objArray = numberStream.toArray();

// Вариант 2: Типизированный массив
Integer[] intArray = numberStream.toArray(Integer[]::new);
```

#### **Stream → Коллекция**
```java
List<String> names = Stream.of("Alice", "Bob", "Charlie")
    .filter(name -> name.length() > 3)
    .collect(Collectors.toList()); // ["Alice", "Charlie"]

Set<Integer> uniqueNumbers = Stream.of(1, 2, 2, 3, 3)
    .collect(Collectors.toSet()); // [1, 2, 3]
```

---

### **Важные замечания**
1. **Однократное использование**: После вызова `toArray()` или `collect()` поток закрывается — повторное использование вызовет `IllegalStateException`.
2. **Изменяемость коллекций**:
   - `Collectors.toList()` в Java 9+ возвращает **неизменяемый список**. 
   - Для изменяемого списка используйте:
     ```java
     List<String> list = stream.collect(Collectors.toCollection(ArrayList::new));
     ```
3. **Порядок элементов**: В `Set` порядок может быть потерян (если только это не `LinkedHashSet`).

---

### **Итог**
| Цель          | Метод                                 | Пример                                                      |
|---------------|---------------------------------------|-------------------------------------------------------------|
| **Массив**    | `stream.toArray()`                    | `String[] arr = stream.toArray(String[]::new);`             |
| **List**      | `collect(Collectors.toList())`        | `List<String> list = stream.collect(Collectors.toList());`  |
| **Set**       | `collect(Collectors.toSet())`         | `Set<Integer> set = stream.collect(Collectors.toSet());`    |
| **Конкретная коллекция** | `Collectors.toCollection()` | `LinkedList<String> ll = stream.collect(Collectors.toCollection(LinkedList::new));` |

Преобразование Stream в массив или коллекцию — это стандартный способ завершения работы с потоком, чтобы получить результат в удобной форме.

---
---
### 23. В чём отличие методов orElseGet и orElse?
В Java методы `orElse` и `orElseGet` используются для работы с `Optional<T>` и предоставляют значение по умолчанию, если `Optional` пуст. Однако между ними есть **ключевое отличие** в поведении:

---

### **1. `orElse(T value)`**
- **Что делает**:  
  Возвращает значение из `Optional`, если оно присутствует. Если `Optional` пуст, возвращает переданное значение `value`.  
- **Когда вычисляется `value`**:  
  Значение `value` вычисляется **немедленно**, даже если `Optional` не пуст.  
- **Пример**:  
  ```java
  String result = optionalValue.orElse(expensiveOperation()); 
  // expensiveOperation() выполнится ВСЕГДА, даже если optionalValue не пуст
  ```

---

### **2. `orElseGet(Supplier<T> supplier)`**
- **Что делает**:  
  Возвращает значение из `Optional`, если оно присутствует. Если `Optional` пуст, вызывает `Supplier` и возвращает его результат.  
- **Когда вычисляется `supplier`**:  
  `Supplier` выполняется **только при пустом `Optional`**. Это "ленивое" вычисление.  
- **Пример**:  
  ```java
  String result = optionalValue.orElseGet(() -> expensiveOperation());
  // expensiveOperation() выполнится ТОЛЬКО если optionalValue пуст
  ```

---

### **Когда использовать?**
- **`orElse`** — если значение по умолчанию **легко вычисляется** (например, константа или простая операция).  
  ```java
  optionalValue.orElse("default");
  ```

- **`orElseGet`** — если получение значения по умолчанию **ресурсоёмко** (например, вызов метода, запрос к БД, создание объекта).  
  ```java
  optionalValue.orElseGet(() -> fetchFromDatabase()); // Запрос к БД только при необходимости
  ```

---

### **Пример для наглядности**
```java
public class Example {
    public static void main(String[] args) {
        Optional<String> nonEmptyOptional = Optional.of("Hello");
        Optional<String> emptyOptional = Optional.empty();

        // orElse: вычисляется всегда
        System.out.println(nonEmptyOptional.orElse(getDefault())); // Выведет "Hello", но getDefault() всё равно выполнится
        System.out.println(emptyOptional.orElse(getDefault()));   // Вызовет getDefault()

        // orElseGet: вычисляется только при необходимости
        System.out.println(nonEmptyOptional.orElseGet(() -> getDefault())); // "Hello", getDefault() НЕ выполнится
        System.out.println(emptyOptional.orElseGet(() -> getDefault()));     // Вызовет getDefault()
    }

    private static String getDefault() {
        System.out.println("Выполняется getDefault()");
        return "Default Value";
    }
}
```

**Вывод:**
```
Выполняется getDefault()  // orElse с nonEmptyOptional
Hello
Выполняется getDefault()  // orElse с emptyOptional
Default Value
Hello                      // orElseGet с nonEmptyOptional (getDefault() не вызывается)
Выполняется getDefault()  // orElseGet с emptyOptional
Default Value
```

---

### **Итог**
| Метод          | Когда вычисляется значение по умолчанию? | Оптимизация ресурсов | Использование |
|----------------|-------------------------------------------|-----------------------|---------------|
| **`orElse`**   | Всегда (даже если `Optional` не пуст)     | Нет                   | Для простых значений |
| **`orElseGet`**| Только при пустом `Optional`              | Да (ленивое выполнение) | Для сложных/ресурсоёмких операций | 

Всегда выбирайте `orElseGet`, если создание значения по умолчанию требует значительных вычислений — это улучшит производительность.

---
---
### 24. Каким образом можно реализовать обработку ошибок с использованием Optional и метод orElseThrow?
Для обработки ошибок с использованием `Optional` и метода `orElseThrow()` в Java можно элегантно заменить традиционные проверки на `null` и явные выбросы исключений. Вот как это работает:

---

### **1. Основы метода `orElseThrow()`**
Метод `orElseThrow()` класса `Optional`:
- **Если значение присутствует** — возвращает его.
- **Если значение отсутствует** — выбрасывает исключение, заданное разработчиком.

Есть две версии метода:
1. **`orElseThrow()`** — бросает `NoSuchElementException` по умолчанию.
2. **`orElseThrow(Supplier<X> exceptionSupplier)`** — бросает исключение, созданное через `Supplier`.

---

### **2. Примеры использования**

#### **a) Базовый пример (с непроверяемым исключением)**
```java
Optional<String> optionalValue = Optional.ofNullable(getValueFromExternalSource());

try {
    String value = optionalValue
        .orElseThrow(() -> new RuntimeException("Значение не найдено"));
    System.out.println("Получено: " + value);
} catch (RuntimeException e) {
    System.err.println("Ошибка: " + e.getMessage());
}
```

#### **b) С проверяемым (checked) исключением**
Если нужно бросить проверяемое исключение (например, `IOException`), оберните его в `RuntimeException` или используйте лямбду с блоком `try-catch`:
```java
public String readConfig() throws IOException {
    Optional<String> config = Optional.ofNullable(readFromFile());
    return config.orElseThrow(() -> new IOException("Файл конфигурации не найден"));
}
```

---

### **3. Кастомизация исключений**
Вы можете создавать исключения с дополнительной информацией:
```java
Optional<User> userOptional = userRepository.findById(userId);

User user = userOptional.orElseThrow(() -> 
    new EntityNotFoundException("Пользователь с ID " + userId + " не найден")
);
```

---

### **4. Сравнение с традиционным подходом**
**Без `Optional`**:
```java
User user = userRepository.findById(userId);
if (user == null) {
    throw new EntityNotFoundException("Пользователь не найден");
}
```

**С `Optional`**:
```java
User user = userRepository.findById(userId)
    .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден"));
```
Код становится лаконичнее и выразительнее.

---

### **5. Лучшие практики**
1. **Используйте `orElseThrow` для обязательных значений**. Если отсутствие значения — это ошибка, выбрасывайте исключение.
2. **Добавляйте информативные сообщения**. Это упростит отладку.
3. **Для проверяемых исключений**:
   - Оберните их в `RuntimeException`, если не хотите добавлять `throws` в сигнатуру метода.
   - Либо обрабатывайте в блоке `try-catch`.

---

### **6. Пример с цепочкой методов**
```java
public String getProductPrice(int productId) {
    return productRepository.findById(productId)
        .map(Product::getPrice)
        .map(price -> "$" + price)
        .orElseThrow(() -> new IllegalArgumentException("Товар не существует"));
}
```

---

### **7. Обработка нескольких Optional**
Если нужно проверить несколько значений:
```java
Optional<String> login = Optional.ofNullable(request.getLogin());
Optional<String> password = Optional.ofNullable(request.getPassword());

User user = login.flatMap(l -> password.map(p -> authenticate(l, p)))
    .orElseThrow(() -> new AuthException("Логин или пароль отсутствуют"));
```

---

### **Итог**
Метод `orElseThrow()` в `Optional` позволяет:
- Избежать `if (value == null)`.
- Четко выразить намерение: «это значение обязательно, его отсутствие — ошибка».
- Легко кастомизировать исключения.

**Важно!** Не злоупотребляйте исключениями. Используйте `orElseThrow()` только там, где отсутствие значения действительно является **исключительной ситуацией**. Для опциональных данных подойдут `orElse()`, `orElseGet()` или возврат `Optional` из метода.