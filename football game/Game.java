import java.util.*;
import java.io.*;
/**
 * The main method for playing game.
 *
 * @author Lin Han
 * @version 2018/05/22
 */
public class Game
{
    private ArrayList<Team> teams;
    private ArrayList<Team> fairTeams;
    private Scanner input;
    private RandomGoalsGenerator random;
    private ArrayList<Team> goldenTeam;
    private ArrayList<Player> goldenPlayers;
    private boolean playedA;
    private boolean playedB;

    /**
     * default constructor of Game class
     */
    public Game()
    {
        teams = new ArrayList<>();
        input = new Scanner(System.in);
        random = new RandomGoalsGenerator();
        fairTeams = new ArrayList<Team>();
        readFile();
        goldenTeam = new ArrayList<Team>();
        goldenPlayers = new ArrayList<>();
        playedA = false;
        playedB = false;
    }

    /**
     * non-default constructor of Game class
     */
    public Game(ArrayList<Team> teams)
    {
        this.teams = teams;
        input = new Scanner(System.in);
        random = new RandomGoalsGenerator();
        fairTeams = new ArrayList<Team>();
        readFile();
        goldenTeam = new ArrayList<Team>();
        goldenPlayers = new ArrayList<>();
        playedA = false;
        playedB = false;
    }

    /**
     * method of input players for each team
     */
    private void choosePlayer()
    {
        for (int i = 0; i < teams.size(); i++)
        {
            System.out.println("please input the two players for " + teams.get(i).getName());
            int count = 0;
            while (true)
            {
                System.out.println("you can only input characters, and only one '-' ");
                System.out.println("you can input the first player's name");
                String inputOne = input.nextLine();
                if (checkName(inputOne))        
                {
                    teams.get(i).getPlayerOne().setName(inputOne);
                    break;
                }
                else
                {
                    System.out.println("invalid,you have one chance to re-enter the name");
                    count++;
                    if (count == 2)
                    {
                        teams.get(i).getPlayerOne().setName("player-"+i+"-mm");
                        break;
                    }
                }
            }
            count = 0;
            while (true)
            {
                System.out.println("you can only input characters, and only one '-' ");
                System.out.println("Now, you can input second player's name");
                String inputTwo = input.nextLine();
                if (checkName(inputTwo))
                {
                    teams.get(i).getPlayerTwo().setName(inputTwo);
                    break;
                }
                else
                {
                    System.out.println("invalid");
                    count++;
                    if (count == 2)
                    {
                        teams.get(i).getPlayerOne().setName("player-"+i+"-mm");
                        break;
                    }
                }
            }
        }
    }

    /**
     * method of checking name validation
     * @pere name
     */
    private boolean checkName(String name)
    {
        boolean valid = false;
        if (name.matches("^[a-zA-Z\\-]{2,20}$"))
        {
            if (name.indexOf("-") != 0 && name.indexOf("-") != name.length()-1)
            { 
                int count = 0;
                for (int i = 0; i < name.length(); i++)
                {
                    if (name.charAt(i)=='-')
                        count++;
                }
                if (count <= 1)
                    valid = true;
            }
        }
        return valid;
    }

    /**
     * display game results
     */
    private void disGameResults(int i, int j)
    {
        System.out.println("Game result: " + teams.get(i).getName() + " " + (teams.get(i).getPlayerOne().getGoals()+teams.get(i).getPlayerTwo().getGoals()) +
            " VS " + teams.get(j).getName() + " " + (teams.get(j).getPlayerOne().getGoals()+teams.get(j).getPlayerTwo().getGoals()) );
        if (random.generateRedCard())
        {
            teams.get(i).setRedScore(teams.get(i).redCardScore() + 2);
            System.out.println("Card Awarded: " + teams.get(i).getName() + " 1 red card");
        }
        if (random.generateYellowCard())
        {
            teams.get(i).setYellowScore(teams.get(i).yellowCardScore() + 1);
            System.out.println("Card Awarded: " + teams.get(i).getName() + " 1 yellow card");
        }
        if (random.generateRedCard())
        {
            teams.get(j).setRedScore(teams.get(j).redCardScore() + 2);
            System.out.println("Card Awarded: " + teams.get(i).getName() + " 1 red card");
        }
        if (random.generateYellowCard())
        {
            teams.get(j).setYellowScore(teams.get(j).yellowCardScore() + 1);
            System.out.println("Card Awarded: " + teams.get(i).getName() + " 1 yellow card");
        }
        System.out.println("----------------------------");

    }

    /**
     * display main menu
     */
    private void displayMenu()
    {
        System.out.println("searching options");
        System.out.println("you must play Preliminary Stage first, then you can play final game");
        System.out.println("A. Play Preliminary Stage");
        System.out.println("B. Play Final");
        System.out.println("C. Display teams");
        System.out.println("D. Display Players");
        System.out.println("E. Display Cup Result");
        System.out.println("X. Close");
    }

    /**
     * method of sorting ArrayList in of JAVA
     */
    private void displayRanking()
    {
        Comparator<Team> comparator = new Comparator<Team>()
            {
                public int compare(Team t1, Team t2)
                {
                    if (t1.getPoint() != t2.getPoint())
                        return t2.getPoint()-t1.getPoint();
                    else
                        return (t2.getPlayerOne().getGoals()+t2.getPlayerTwo().getGoals())-(t1.getPlayerOne().getGoals()+t1.getPlayerTwo().getGoals());
                }
            };
        Collections.sort(teams,comparator);
        for (int i = 0; i < teams.size(); i++)
            System.out.println(teams.get(i).getName() + ": "+ (i + 1));
    }

    /**
     * method of displaying details of each team
     */
    private void displayTeams()
    {
        System.out.println("                 Played       Won    Lost    Drawn    Goals    Points     Fair Play Score");
        for (Team team : teams)
        {
            System.out.println(team.getName().substring(0,5) + "                " + (team.getWon() + team.getDrawn() + team.getLost()) + "        " + team.getWon() + "      " +
                team.getLost() + "        " + team.getDrawn() +
                "         " + (team.getPlayerOne().getGoals() + team.getPlayerTwo().getGoals()) + "          " + 
                team.getPoint() + "           " + (team.yellowCardScore() + team.redCardScore()));
        }
    }

    /**
     * method of displaying details of each players of each team
     */
    private void displayPlayers()
    {
        System.out.println("the players are displayed here: ");
        for (Team team : teams)
        {
            System.out.println(team.getPlayerOne().getName() + " (" + team.getName() + ")  - " + team.getPlayerOne().getGoals());
            System.out.println(team.getPlayerTwo().getName() + " (" + team.getName() + ")  - " + team.getPlayerTwo().getGoals());
        }
    }

    /**
     * method of displaying the cup result
     */
    private void displayCupResult()
    {        
        System.out.println("Football World Cup Winner :" + teams.get(0).getName());
        goldenAward();
        findFairPlay();
    }

    /**
     * method of finding fair play team
     */
    private void findFairPlay()
    {
        int fair = (teams.get(0).yellowCardScore() + teams.get(0).redCardScore());
        for (Team team : teams)
        {
            if ((team.yellowCardScore()+team.redCardScore()) < fair)
            {
                fair = (team.yellowCardScore() + team.redCardScore());
                fairTeams.clear();
                fairTeams.add(team);
            }
            else if ((team.yellowCardScore()+team.redCardScore()) == fair)
            {
                fairTeams.add(team);
            }
        }
        System.out.print(" FairPlay Award: ");
        for (Team team : fairTeams)
        {
            System.out.print(team.getName() + ", " );
        }
        System.out.println();
    }

    /**
     * method of playing final stage
     */
    private void finalGame()
    {
        int finalGoalsOne = random.randomForHigherTeam();
        int finalGoalsTwo = random.randomForLowerTeam(1);
        int playOneGoal = random.playerScore(finalGoalsOne);
        int playTwoGoal = finalGoalsOne - playOneGoal;
        int playOneGoalTwo = random.playerScore(finalGoalsTwo);
        int playTwoGoalTwo = finalGoalsTwo - playOneGoalTwo;
        System.out.println("now, start playing the final game");
        if (finalGoalsOne > finalGoalsTwo)
        {
            System.out.println(teams.get(0).getName() + " 's goals are " + finalGoalsOne);
            System.out.println(teams.get(1).getName() + " 's goals are " + finalGoalsTwo);
            System.out.println("the team: " + teams.get(0).getName() + " is winner!");
            teams.get(0).getPlayerOne().setGoals(playOneGoal);
            teams.get(0).getPlayerTwo().setGoals(playTwoGoal);
            teams.get(1).getPlayerOne().setGoals(playOneGoalTwo);
            teams.get(1).getPlayerTwo().setGoals(playTwoGoalTwo);
        }
        if (finalGoalsOne < finalGoalsTwo)
        {
            System.out.println(teams.get(0).getName() + " 's goals are " + finalGoalsOne);
            System.out.println(teams.get(1).getName() + " 's goals are " + finalGoalsTwo);
            System.out.println("the team: " + teams.get(1).getName() + " is winner!");
            teams.get(0).getPlayerOne().setGoals(playOneGoal);
            teams.get(0).getPlayerTwo().setGoals(playTwoGoal);
            teams.get(1).getPlayerOne().setGoals(playOneGoalTwo);
            teams.get(1).getPlayerTwo().setGoals(playTwoGoalTwo);
        }
        if (finalGoalsOne == finalGoalsTwo)
        {
            System.out.println(teams.get(0).getName() + " 's goals are " + finalGoalsOne);
            System.out.println(teams.get(1).getName() + " 's goals are " + finalGoalsTwo);
            System.out.println("now, we start playing the penalty shoot!");
            System.out.println("the team: " + teams.get(playPenaltyShootOut()).getName() + " is winner!");
            teams.get(0).getPlayerOne().setGoals(playOneGoal);
            teams.get(0).getPlayerTwo().setGoals(playTwoGoal);
            teams.get(1).getPlayerOne().setGoals(playOneGoalTwo);
            teams.get(1).getPlayerTwo().setGoals(playTwoGoalTwo);
        }
    }

    /**
     * method of getting golden award player
     */
    private void goldenAward()
    {
        int score = 0;
        for (Team team : teams)
        {
            if (team.getPlayerOne().getGoals() > score)
            {
                score = team.getPlayerOne().getGoals();
                goldenPlayers.clear();
                goldenPlayers.add(team.getPlayerOne());
                goldenTeam.clear();
                goldenTeam.add(team);
            }
            else if (team.getPlayerOne().getGoals() == score)
            {
                goldenPlayers.add(team.getPlayerOne());
                goldenTeam.add(team);
            }
            if (team.getPlayerTwo().getGoals() > score)
            {
                score = team.getPlayerTwo().getGoals();
                goldenPlayers.clear();
                goldenPlayers.add(team.getPlayerTwo());
                goldenTeam.clear();
                goldenTeam.add(team);
            }
            else if (team.getPlayerTwo().getGoals() == score)
            {
                goldenPlayers.add(team.getPlayerTwo());
                goldenTeam.add(team);
            }
        }
        System.out.print("Golden Boot Award: " );
        for (Player player : goldenPlayers)
        {
            System.out.print(player.getName() + ", " );
        }
        System.out.print(" from: ");
        for (Team team : goldenTeam)
        {
            System.out.print(team.getName() + ", " );
        }
        System.out.println();
    }

    /**
     * menu of playing
     */
    public void menu()
    {
        displayMenu();
        System.out.println("input your option");
        String choose = input.nextLine();
        while (!choose.equalsIgnoreCase("X"))
        {
            switch (choose.toUpperCase())
            {
                case "A":
                playGame();
                playedA = true;
                break;
                case "B":
                if (playedA)
                {
                    finalGame();
                    playedB = true;
                }
                else 
                    System.out.println("you must play preliminary stage first");
                break;
                case "C":
                displayTeams();
                break;
                case "D":
                displayPlayers();
                break;
                case "E":
                if (playedB)
                    displayCupResult();
                else
                    System.out.println("you must finish final game");
                break;
                default:
                System.out.println("error only choose A - X ");
            }
            displayMenu();
            System.out.println("input your option");
            choose = input.nextLine();
        }
        if (choose.equalsIgnoreCase("X"))
            outputFile();
    }

    /**
     * method of output file
     */
    private void outputFile()
    {
        if (playedB)
        {
            try
            {
                String filename = ("statistics.txt");
                PrintWriter outputFile = new PrintWriter(filename);
                outputFile.println("Football World Cup Winner :" + teams.get(0).getName());
                outputFile.print("Golden Boot Award: " );
                for (Player player : goldenPlayers)
                {
                    outputFile.print(player.getName() + ", " );
                }
                outputFile.print(" from: ");
                for (Team team : goldenTeam)
                {
                    outputFile.print(team.getName() + ", " );
                }
                outputFile.println();
                for (Team team : fairTeams)
                {
                    outputFile.print(team.getName() + ", " );
                }
                outputFile.println();
                outputFile.print("FairPlay Award: ");
                for (Team team : fairTeams)
                {
                    outputFile.print(team.getName() + ", " );
                }
                outputFile.println();
                outputFile.close();
            }
            catch(IOException exception)
            {
                System.out.println("Unexpected I/O exception occurs");
            } 
        }
    }

    /**
     * play penalty shoot method
     */
    private int playPenaltyShootOut()
    {
        int teamOneShoot = 0;
        int teamTwoShoot = 0;
        int i= 0;
        while (i < 5)
        {
            int shootOne = 1+ (int)(Math.random() * 100);
            int shootTwo = 1+ (int)(Math.random() * 100);
            if (shootOne <= 40)
            {
                teamOneShoot++;
            }
            if (shootTwo <= 40)
                teamTwoShoot++;
            i++;
        }
        System.out.println(teams.get(0).getName() + " shoot is " + teamOneShoot);
        System.out.println(teams.get(1).getName() + " shoot is " + teamTwoShoot);
        while (teamOneShoot == teamTwoShoot)
        {
            int shootOne = 1+ (int)(Math.random() * 100);
            int shootTwo = 1+ (int)(Math.random() * 100);
            if (shootOne <= 40)
                teamOneShoot++;
            if (shootTwo <= 40)
                teamTwoShoot++;
            System.out.println(teams.get(0).getName() + " shoot is " + teamOneShoot);
            System.out.println(teams.get(1).getName() + " shoot is " + teamTwoShoot);
        }
        if (teamOneShoot > teamTwoShoot)
        {
            return 0;
        }
        else
            return 1;
    }

    /**
     * method of playing preliminary stage 
     */
    private void playGame()
    {
        choosePlayer();        
        System.out.println("now, we start playing the preliminary stage!!!!!");
        for (int i = 0; i < teams.size(); i++)
        {
            int rank = Integer.valueOf(teams.get(i).getRanking()).intValue();
            for (int j = i+1; j <teams.size(); j++)
            {
                int rankTwo = Integer.valueOf(teams.get(j).getRanking()).intValue();
                int goalsOne = 0;
                int goalsTwo = 0;
                if (rank > rankTwo)
                {
                    goalsOne = random.randomForHigherTeam();
                    int playOneGoal = random.playerScore(goalsOne);
                    int playTwoGoal = goalsOne - playOneGoal;
                    teams.get(i).getPlayerOne().setGoals(playOneGoal);
                    teams.get(i).getPlayerTwo().setGoals(playTwoGoal);
                    int difference = rank - rankTwo;
                    goalsTwo = random.randomForLowerTeam(difference);
                    playOneGoal = random.playerScore(goalsTwo);
                    playTwoGoal = goalsTwo - playOneGoal;
                    teams.get(j).getPlayerOne().setGoals(playOneGoal);
                    teams.get(j).getPlayerTwo().setGoals(playTwoGoal);
                }
                else 
                {
                    goalsOne = random.randomForHigherTeam();
                    int playOneGoal = random.playerScore(goalsOne);
                    int playTwoGoal = goalsOne - playOneGoal;
                    teams.get(j).getPlayerOne().setGoals(playOneGoal);
                    teams.get(j).getPlayerTwo().setGoals(playTwoGoal);
                    int difference = rank - rankTwo;
                    goalsTwo = random.randomForLowerTeam(difference);
                    playOneGoal = random.playerScore(goalsTwo);
                    playTwoGoal = goalsTwo - playOneGoal;
                    teams.get(i).getPlayerOne().setGoals(playOneGoal);
                    teams.get(i).getPlayerTwo().setGoals(playTwoGoal);
                }
                if (goalsOne > goalsTwo)
                {
                    teams.get(i).setPoint(teams.get(i).getPoint()+3);
                    teams.get(i).setWon(teams.get(i).getWon()+1);
                    teams.get(j).setLost(teams.get(j).getLost()+1);
                }
                if (goalsOne == goalsTwo)
                {
                    teams.get(i).setPoint(teams.get(i).getPoint()+1);
                    teams.get(j).setPoint(teams.get(j).getPoint()+1);
                    teams.get(i).setDrawn(teams.get(i).getDrawn()+1);
                    teams.get(j).setDrawn(teams.get(j).getDrawn()+1);
                }
                if (goalsOne < goalsTwo)
                {
                    teams.get(j).setPoint(teams.get(j).getPoint()+3);
                    teams.get(j).setWon(teams.get(j).getWon()+1);
                    teams.get(i).setLost(teams.get(i).getLost()+1);
                }
                disGameResults(i,j);
            }
        }
        displayRanking();
    }

    /**
     * read file method
     */
    private void readFile()
    {
        String filename = "teams.txt";
        try
        {
            FileReader inputFile = new FileReader(filename);
            Scanner parser = new Scanner(inputFile);
            int teamNum = 0;
            while(parser.hasNextLine())
            {
                String line = parser.nextLine();
                Team team = new Team();
                teams.add(team);                 
                String[] ary = line.split(",");
                teams.get(teamNum).setName(ary[0]);
                teams.get(teamNum).setRanking(ary[1]);                
                teamNum++;
            }            
        }
        catch(Exception e)
        {
            System.out.println("can not find the file");
        }
    }
}

