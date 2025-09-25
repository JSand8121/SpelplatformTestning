/*
 * This is a game called Burr, for more information about the game goto:
 * https://www.dryckesspel.se/burr/
 */
package Burr;

/**
 *
 * @author marda237
 */
public class Burr {

    /*
    Starting up the game.
    Burr.GameRules is taking two parameters: Number of players and the divider.
    StarGame launches the players to play "Burr".
     */
    
    public static void main(String[] args){
        StartGame game = new StartGame();
        game.start();
    }
    
}
