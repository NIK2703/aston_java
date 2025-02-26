package ru.aston.ogurnoy_na.patterns.behavioural.mediator;

public class MediatorDemo {
    public static void main(String[] args) {
        Mediator chatMediator = new ChatMediator();

        Colleague user1 = new User(chatMediator, "Алиса");
        Colleague user2 = new User(chatMediator, "Боб");
        Colleague user3 = new User(chatMediator, "Чарли");

        chatMediator.addColleague(user1);
        chatMediator.addColleague(user2);
        chatMediator.addColleague(user3);

        user1.send("Привет всем!");
        user2.send("Как дела?");
    }
}