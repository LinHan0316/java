
/**
 * Player class is used to store and read the player's details,
 * 
 * @author LIN HAN 
 * @version 2018,04,15
 */
public class Player
{
    private String name;
    private int score;
    private int guesses;
    private int comScore;
    private int comGuess;
    /**
     * the constructors of Player class
     */
    public  Player()
    {
        score = 0;
        guesses = 0;
        name = "";
        comScore = 0;
        comGuess = 0;
    }

    /**
     * non-default constructor of Player class
     */
    public Player(String newName, int newScore,int newGuess,int newComputerNum,int newComScore)
    {
        name = newName;
        score = newScore;
        guesses = newGuess;
        comScore = newComScore;
        comGuess = newComputerNum;                
    }

    /**
     * this method is used to get the human player's score.
     * @return the human player's score
     */
    public int getScore()
    {
        return score;
    }   

    /**
     * this method is used to get the computer player's score.
     * @return the computer player's score
     */
    public int getComScore()
    {
        return comScore;
    }

    /**
     * this method is used to get the player's name.
     * @return the player's name
     */
    public String getName()
    {
        return name;
    }    

    /**
     * this method is used to get the human player's guess number.
     * @return the human player's number
     */
    public int getGuesses()
    {
        return guesses;
    }

    /**
     * this method is used to get the computer player's guess number.
     * @return the computer player's number
     */
    public int getComGuess()
    {
        return comGuess;
    }

    /**
     * this method is used to set score for human player.
     * @parameter currentScore, 
     */
    public void setScore(int currentScore)
    {
        score += currentScore;
    }

    /**
     * this method is used to set score for computer player.
     * @parameter currentScore, 
     */
    public void setComScore(int currentComScore)
    {
        comScore += currentComScore;
    }

    /**
     * this method is used to set name for human player.
     * @parameter playerName 
     */
    public  void setName(String playerName)
    {
        name = playerName;
    }

    /**
     * this method is used to set guesses for human player.
     * @parameter currentGuesses, 
     */
    public void setGuesses(int currentGuesses)
    {
        guesses += currentGuesses;
    }

    /**
     * this method is used to set guesses for computer player.
     * @parameter currentComGuess, 
     */
    public void setComGuess(int currentComGuess)
    {
        comGuess += currentComGuess;
    }

}

