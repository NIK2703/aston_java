package ru.aston.ogurnoy_na.patterns.structural.proxy;

public class SecurityProxy implements FileSystem {
    private RealFileSystem realFileSystem;
    private String userRole;

    public SecurityProxy(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String readFile(String filename) {
        // Ленивая инициализация реального объекта
        if (realFileSystem == null) {
            realFileSystem = new RealFileSystem();
        }

        // Проверка прав доступа
        if ("admin".equals(userRole)) {
            return realFileSystem.readFile(filename);
        } else {
            return "Ошибка: доступ запрещен";
        }
    }
}