package ru.aston.ogurnoy_na.patterns.structural.facade;

class HomeTheaterFacade {
    private Amplifier amp;
    private DvdPlayer dvd;
    private Projector projector;
    private Screen screen;

    public HomeTheaterFacade(Amplifier amp, DvdPlayer dvd,
                             Projector projector, Screen screen) {
        this.amp = amp;
        this.dvd = dvd;
        this.projector = projector;
        this.screen = screen;
    }

    public void watchMovie(String movie) {
        System.out.println("\n=== Начинаем просмотр фильма ===");
        screen.down();
        projector.on();
        amp.on();
        amp.setVolume(25);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("\n=== Завершаем просмотр ===");
        dvd.off();
        amp.off();
        projector.off();
        screen.up();
    }
}