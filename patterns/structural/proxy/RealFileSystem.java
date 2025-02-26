package ru.aston.ogurnoy_na.patterns.structural.proxy;

public class RealFileSystem implements FileSystem {
    @Override
    public String readFile(String filename) {
        // Имитация чтения файла
        return "Содержимое файла " + filename;
    }
}