package Burr;

/**
 * Created 2019-10-21
 */
public class StartGame {
    public void start() {
        GameRules gr = new GameRules(3,5);
        gr.startGame();
    }
}