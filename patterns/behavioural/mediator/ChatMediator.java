package ru.aston.ogurnoy_na.patterns.behavioural.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediator implements Mediator {
    private List<Colleague> colleagues = new ArrayList<>();

    @Override
    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void sendMessage(String message, Colleague sender) {
        for (Colleague colleague : colleagues) {
            // Сообщение не отправляется отправителю
            if (colleague != sender) {
                colleague.receive(message);
            }
        }
    }
}