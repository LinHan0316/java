/**
 * the methods for set and get for Player class
 *
 * @author Lin Han
 * @version 2018/05/22
 */
public class Player
{
    private String name;
    private int goals;

    /**
     * default constructor for Player Class
     */
    public Player()
    {
        name = "XX-XX";
        goals = 0;
    }

    /**
     * non-default constructor for Player Class
     */
    public Player(String newName, int newGoals)
    {
        name = newName;
        goals = newGoals;
    }

    /**
     * method for setting name for player
     * @pere playerName
     */
    public void setName(String playerName)
    {
        name = playerName;
    }

    /**
     * method for getting goals
     * @return goals
     */
    public int getGoals()
    {
        return goals;
    }

    /**
     * method for setting goals for player
     * @pere playerGoals
     */
    public void setGoals(int playerGoals)
    {
        goals = playerGoals;
    }

    /**
     * method for getting name
     * @return name
     */
    public String getName()
    {
        return name;
    }
}
