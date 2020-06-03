/**
 * the methods for set and get for Team class
 *
 * @author Lin Han
 * @version 2018/05/22
 */
public class Team
{
    private String name;
    private String ranking;
    private Player playerOne;
    private Player playerTwo;
    private int yellowCardScore;
    private int redCardScore;
    private int point;
    private int won;
    private int lost;
    private int drawn;

    /**
     * default constructor
     */
    public Team()
    {
        name = "";
        ranking = "";
        playerOne = new Player();
        playerTwo = new Player();
        yellowCardScore = 0;
        redCardScore = 0;
        point = 0;
        won = 0;
        lost = 0;
        drawn = 0;
    }

    /**
     * non-default constructor
     */
    public Team(String newName, String newRanking, Player newPlayerOne, Player newPlayerTwo, int newYCard, int newRCard, int newPoint, int newWon, int newLost, int newDrawn)
    {
        name = newName;
        ranking = newRanking;
        playerOne = newPlayerOne;
        playerTwo = newPlayerTwo;
        yellowCardScore = newYCard;
        redCardScore = newRCard;
        point = newPoint;
        won = newWon;
        lost = newLost;
        drawn = newDrawn;
    }

    /**
     * get name of team
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * get how many times of won of team
     * @return won
     */
    public int getWon()
    {
        return won;
    }

    /**
     * get how many times of lost of team
     * @return lost
     */
    public int getLost()
    {
        return lost;
    }

    /**
     * get how many times of drawn of team
     * @return drawn
     */
    public int getDrawn()
    {
        return drawn;
    }

    /**
     * get ranking of team
     * @return ranking
     */
    public String getRanking()
    {
        return ranking;
    }    

    /**
     * get player one
     * @return playerOne
     */
    public Player getPlayerOne()
    { 
        return playerOne;        
    }

    /**
     * get player two
     * @return playerTwo
     */
    public Player getPlayerTwo()
    { 
        return playerTwo;        
    }

    /**
     * get total points for team
     * @return point
     */
    public int getPoint()
    {
        return point;
    }

    /**
     * get red cards of team
     * @return redCardScore
     */
    public int redCardScore()
    {
        return redCardScore;
    }

    /**
     * setting name for team
     * @pere team's name
     */
    public void setName(String teamName)
    {
        name = teamName;
    }

    /**
     * setting how many times of won for team
     * @pere team's won
     */
    public void setWon(int teamWon)
    {
        won = teamWon;
    }

    /**
     * setting how many times of lost for team
     * @pere team's lost
     */
    public void setLost(int teamLost)
    {
        lost = teamLost;
    }

    /**
     * setting how many times of draw for team
     * @pere team's draw
     */
    public void setDrawn(int teamDrawn)
    {
        drawn = teamDrawn;
    }

    /**
     * setting ranking for team
     * @pere team's ranking
     */
    public void setRanking(String teamRanking)
    {
        ranking = teamRanking;
    }

    /**
     * setting yellow card numbers for team
     * @pere team's yellow card numbers
     */
    public void setYellowScore(int teamYCardScore)
    {
        yellowCardScore = teamYCardScore;
    }

    /**
     * setting red card numbers for team
     * @pere team's red card numbers
     */
    public void setRedScore(int teamRCardScore)
    {
        redCardScore = teamRCardScore;
    }

    /**
     * setting point for team
     * @pere teamPoint
     */
    public void setPoint(int teamPoint)
    {
        point = teamPoint;
    }

    /**
     * get yellow cards of team
     * @return yellowCardScore
     */
    public int yellowCardScore()
    {
        return yellowCardScore;
    }
}
