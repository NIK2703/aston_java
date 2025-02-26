package ru.aston.ogurnoy_na.patterns.behavioural.state;

public class StateDemo {
    public static void main(String[] args) {
        PlayerContext player = new PlayerContext();

        player.play();  // ▶️ Начинаем воспроизведение
        player.setState(new PlayState());

        player.pause(); // ⏸️ Пауза
        player.setState(new PauseState());

        player.play();   // ▶️ Продолжаем воспроизведение
        player.stop();  // ⏹️ Остановка
        player.setState(new StopState());

        player.pause(); // ❌ Ошибка: трек остановлен
    }
}