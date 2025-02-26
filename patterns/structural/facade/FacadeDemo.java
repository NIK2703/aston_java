package ru.aston.ogurnoy_na.patterns.structural.facade;

public class FacadeDemo {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        DvdPlayer dvd = new DvdPlayer();
        Projector projector = new Projector();
        Screen screen = new Screen();

        HomeTheaterFacade theater = new HomeTheaterFacade(amp, dvd, projector, screen);

        theater.watchMovie("Крестный отец");
        theater.endMovie();
    }
}