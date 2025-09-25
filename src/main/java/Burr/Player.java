package Burr;



/**
 * Created 2019-10-21
 */
public class Player {

    //Instance fields
    
    private GameRules rules;
    private int dividerToSkip;
    private int playerNumber;

    /**
    * Constructor
    * @param r - rules for the game
    * @param playerNr - which player in turn
    * @param divider - divider for the game
    */
    public Player(GameRules r, int playerNr, int divider){
        rules = r;
        dividerToSkip = divider;
        playerNumber = playerNr;
    }

    /**
    * Checks the GameRule class for info on the game's state
    * @return  a string depending on the outcome.
     */
    public String play() {
        String s;
        if(rules.getCurrentNumber()%dividerToSkip==0){
            s = "Player " + playerNumber + ": Burr";
        }
        else {
            s = "Player " + playerNumber + ": " +rules.getCurrentNumber();
        }
        rules.increaseCurrentNumber();
        return s;
    }
}