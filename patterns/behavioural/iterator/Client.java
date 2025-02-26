package ru.aston.ogurnoy_na.patterns.behavioural.iterator;

public class Client {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        taskList.addTask("Помыть посуду");
        taskList.addTask("Сделать уроки");
        taskList.addTask("Позвонить маме");

        Iterator<String> iterator = taskList.createIterator();

        while (iterator.hasNext()) {
            System.out.println("Задача: " + iterator.next());
        }
    }
}