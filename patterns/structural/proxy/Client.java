package ru.aston.ogurnoy_na.patterns.structural.proxy;

public class Client {
    public static void main(String[] args) {
        // Пользователь с правами админа
        FileSystem adminProxy = new SecurityProxy("admin");
        System.out.println(adminProxy.readFile("secret.txt"));
        // Вывод: "Содержимое файла secret.txt"

        // Обычный пользователь
        FileSystem userProxy = new SecurityProxy("user");
        System.out.println(userProxy.readFile("secret.txt"));
        // Вывод: "Ошибка: доступ запрещен"
    }
}