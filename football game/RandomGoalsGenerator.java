
/**
 * generate random number
 *
 * @author Lin Han
 * @version 2018/05/22
 */
public class RandomGoalsGenerator
{
    /**
     * Constructor for objects of class RandomGoalsGenerator
     */
    public RandomGoalsGenerator()
    {
        //no constractor, just methods
    }

    /**
     * the method for generating red card 
     * @return red card
     */
    public boolean generateRedCard()
    {
        int redCard = 1+ (int)(Math.random() * 100);
        if (redCard < 6)
        {
            return true;
        }
        return false;
    }

    /**
     * the method for generating yellow card 
     * @return yellow card
     */
    public boolean generateYellowCard()
    {
        int yellowCard = 1+ (int)(Math.random() * 100);
        if (yellowCard < 21)
        {
            return true;
        }
        return false;
    }

    /**
     * the method for generating total team score 
     * @pere team total score
     * @return playerone's score
     */
    public int playerScore(int teamScore)
    {
        int playerOneScore = (int)(Math.random() * (teamScore + 1));
        return playerOneScore;
    }    

    /**
     * the method for generating scores for higher ranked team
     * @return scores
     */
    public int randomForHigherTeam()
    {
        int x = (int)(Math.random() * 3);
        int score = (int)(Math.random() * (6 + x)); 
        return score;
    }
    
    /**
     * the method for generating scores for lower ranked team
     * @return scores
     * @pere the difference 
     */
    public int randomForLowerTeam(int difference)
    {
        int x = (int)(Math.random() * 3);
        int score = (int)(Math.random() * (6 + x - difference)); 
        return score;
    }    
}
