package ru.aston.ogurnoy_na.patterns.behavioural.observer;

public class Client {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        Observer channel1 = new NewsChannel("Канал 1");
        Observer channel2 = new NewsChannel("Канал 2");

        agency.registerObserver(channel1);
        agency.registerObserver(channel2);

        agency.setNews("В Москве прошел сильный дождь!");
        // Вывод:
        // [Канал 1] Получена новость: В Москве прошел сильный дождь!
        // [Канал 2] Получена новость: В Москве прошел сильный дождь!

        agency.removeObserver(channel2);
        agency.setNews("Новый закон о IT-технологиях принят!");
        // Вывод:
        // [Канал 1] Получена новость: Новый закон о IT-технологиях принят!
    }
}