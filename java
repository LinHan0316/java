
#BlueJ class context
comment0.target=Game
comment0.text=\n\ the\ Game\ class\ represents\ the\ main\ object\ for\ the\ gue55ing\ game.\n\ it\ is\ used\ to\ generate\ a\ playing\ \ \n\ \n\ @author\ Lin\ Han\ \n\ @version\ 2018.04.15\n
comment1.params=
comment1.target=Game()
comment1.text=\n\ the\ constructors\ of\ Game\ class\n
comment2.params=guessNum\ hiddenNum\ computerNum
comment2.target=void\ countFinalScore(int,\ int,\ int)
comment2.text=\n\ this\ method\ is\ for\ counting\ scores\ when\ two\ players\ both\ fail\ to\ win\ within\ 6\ guesses\n\ @parameter\ count\ score\ with\ human\ guess\ number,\ hidden\ number,\ and\ computer\ guess\ \n\ number\n
comment3.params=hiddenNum\ computerNum
comment3.target=void\ computerGuess(int,\ int)
comment3.text=\n\ the\ method\ for\ generate\ situation\ when\ computer\ turn\ to\ guess\n\ @parameter\ computer\ takes\ turn\ to\ guess\ with\ hidden\ number\ and\ computer\ guess\ number.\n
comment4.params=i\ guessNum\ hiddenNum\ computerNum
comment4.target=void\ countScore(int,\ int,\ int,\ int)
comment4.text=\n\ this\ method\ for\ counting\ the\ scores\ of\ two\ players\ when\ the\ human\ player\ take\ first\ turn\ to\ guess\n\ two\ players\ win\ within\ the\ 6\ guesses.\n\ @parameter\ count\ score\ with\ guess\ trun\ i\ ,\ human\ guess\ number,\ hidden\ number,\ and\ computer\ guess\ \n\ number\n
comment5.params=i\ guessNum\ hiddenNum\ computerNum
comment5.target=void\ countScoreTwo(int,\ int,\ int,\ int)
comment5.text=\n\ this\ method\ is\ for\ counting\ the\ scores\ of\ two\ players\ when\ computer\ takes\ the\ first\ turn\ to\ guess\n\ two\ players\ win\ within\ the\ 6\ guesses.\n\ @parameter\ count\ score\ with\ guess\ trun\ i\ ,\ human\ guess\ number,\ hidden\ number,\ and\ computer\ guess\ \n\ number\n
comment6.params=hiddenNum\ guessNum
comment6.target=void\ humanGuess(int,\ int)
comment6.text=\n\ the\ method\ for\ generate\ situation\ when\ human\ player\ turn\ to\ guess\n\ @parameter\ human\ takes\ turn\ to\ guess\ with\ hidden\ number\ and\ human\ guess\ number.\n
comment7.params=
comment7.target=void\ play()
comment7.text=\n\ the\ method\ have\ some\ random\ numbers\ and\ two\ players\ take\ turns\ to\ guess\ number\n
comment8.params=
comment8.target=void\ setUpPlayer()
comment8.text=\n\ this\ method\ for\ set\ up\ new\ player\n
comment9.params=
comment9.target=void\ startPlay()
comment9.text=\n\ the\ method\ for\ display\ menu\ and\ start\ play\n
numComments=10

import java.util.*;
/**
 * the Game class represents the main object for the gue55ing game.
 * it is used to generate a playing  
 * 
 * @author Lin Han 
 * @version 2018.04.15
 */
public class Game
{
    private Scanner input;
    private Player gamePlayer;
    private RandomNumber randomNum;
    private int max;
    private int min;
    /**
     * the constructors of Game class
     */
    public Game()
    {
        input = new Scanner(System.in);
        gamePlayer = new Player();
        randomNum = new RandomNumber();
        min = 1; 
        max = 100;
    }

    /**
     * this method is for counting scores when two players both fail to win within 6 guesses
     * @parameter count score with human guess number, hidden number, and computer guess 
     * number
     */
    private void countFinalScore(int guessNum, int hiddenNum, int computerNum)
    {
        System.out.println("in this turn, this is your final guesses: " + guessNum );
        System.out.println("in this turn, this is computer's final guesses "+ computerNum);
        System.out.println("the hidden number is " + hiddenNum);
        int finalScoreOfHuman = 10 - Math.abs(guessNum - hiddenNum);
        int finalScoreOfCom = 10 - Math.abs(computerNum - hiddenNum);
        if (finalScoreOfHuman < 0)
            finalScoreOfHuman = 0;
        if (finalScoreOfCom < 0)
            finalScoreOfCom = 0;
        gamePlayer.setScore(finalScoreOfHuman); 
        gamePlayer.setComScore(finalScoreOfCom);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("In this turn, Your score is  " + finalScoreOfHuman + "  your total socre is " + 
            gamePlayer.getScore());
        System.out.println("In this turn , Computer's score is " + finalScoreOfCom + "  computer total socre is " + 
            gamePlayer.getComScore());       
    }   

    /**
     * the method for generate situation when computer turn to guess
     * @parameter computer takes turn to guess with hidden number and computer guess number.
     */
    private void computerGuess(int hiddenNum, int computerNum)
    {
        if (computerNum > hiddenNum)
        {
            max = computerNum - 1;
            System.out.println("computer's guess is " + computerNum );
            System.out.println("computer's guess is higher");
        }
        if (computerNum < hiddenNum)
        {
            min = computerNum + 1;
            System.out.println("computer's guess is " + computerNum );
            System.out.println("computer's guess is lower");
        }
    }

    /**
     * this method for counting the scores of two players when the human player take first turn to guess
     * two players win within the 6 guesses.
     * @parameter count score with guess trun i , human guess number, hidden number, and computer guess 
     * number
     */
    private void countScore(int i,int guessNum, int hiddenNum, int computerNum)
    {
        if (i == 0 && (guessNum == hiddenNum || computerNum == hiddenNum))
        {
            if (guessNum == hiddenNum)
            {
                System.out.println("the hidden number is " + hiddenNum);
                gamePlayer.setScore(20);
                System.out.println("Congratulations ! you guess the right number at the first attempts");
                System.out.println("you have won 20 scores!");
            }
            if (hiddenNum == computerNum)
            {
                System.out.println("the hidden number is " + hiddenNum);
                System.out.println("the computer guess is " + computerNum);
                gamePlayer.setComScore(15);
                System.out.println("sorry ! computer guess the right number at the 2nd attempts");
                System.out.println("computer have won 15 scores ! you lose! ");
            }
        }
        if (i == 1 && (guessNum == hiddenNum || computerNum == hiddenNum))
        {
            if (guessNum == hiddenNum)
            {
                System.out.println("the hidden number is " + hiddenNum);
                gamePlayer.setScore(11);
                System.out.println("Congratulations ! you guess the right number at the 3th attempts");
                System.out.println("you have won 11 scores!");
            }
            if (hiddenNum == computerNum)
            {
                System.out.println("the hidden number is " + hiddenNum);
                System.out.println("the computer guess is " + computerNum);
                gamePlayer.setComScore(8);
                System.out.println("sorry ! computer guess the right number at the 4th attempts");
                System.out.println("computer have won 5 scores ! you lose! ");
            }
        }
        if (i == 2 && (guessNum == hiddenNum || computerNum == hiddenNum))
        {
            if (guessNum == hiddenNum)
            {
                System.out.println("the hidden number is " + hiddenNum);
                gamePlayer.setScore(6);
                System.out.println("Congratulations ! you guess the right number at the 5th attempts");
                System.out.println("you have won 6 scores!");
            }
            if (hiddenNum == computerNum)
            {
                System.out.println("the hidden number is " + hiddenNum);
                System.out.println("the computer guess is " + computerNum);
                gamePlayer.setComScore(5);
                System.out.println("sorry ! computer guess the right number at the 6th attempts");
                System.out.println("computer have won 5 scores ! you lose! ");
            }
        }
    }

    /**
     * this method is for counting the scores of two players when computer takes the first turn to guess
     * two players win within the 6 guesses.
     * @parameter count score with guess trun i , human guess number, hidden number, and computer guess 
     * number
     */
    private void countScoreTwo(int i,int guessNum, int hiddenNum, int computerNum)
    {
        if (i == 0 && (guessNum == hiddenNum || computerNum == hiddenNum))
        {
            if (hiddenNum == computerNum)
            {
                System.out.println("the hidden number is " + hiddenNum);
                System.out.println("the computer guess is " + computerNum);
                gamePlayer.setComScore(20);
                System.out.println("sorry ! computer guess the right number at the first attempts");
                System.out.println("computer have won 20 scores ! you lose! ");
            }
            if (guessNum == hiddenNum)
            {
                System.out.println("the hidden number is " + hiddenNum);
                gamePlayer.setScore(15);
                System.out.println("Congratulations ! you guess the right number at the 2nd attempts");
                System.out.println("you have won 15 scores!");
            }
        }
        if (i == 1 && (guessNum == hiddenNum || computerNum == hiddenNum))
        {
            if (hiddenNum == computerNum)
            {
                System.out.println("the hidden number is " + hiddenNum);
                System.out.println("the computer guess is " + computerNum);
                gamePlayer.setComScore(11);
                System.out.println("sorry ! computer guess the right number at the 3th attempts");
                System.out.println("computer have won 11 scores ! you lose! ");
            }
            if (guessNum == hiddenNum)
            {
                System.out.println("the hidden number is " + hiddenNum);
                gamePlayer.setScore(8);
                System.out.println("Congratulations ! you guess the right number at the 4th attempts");
                System.out.println("you have won 8 scores!");
            }
        }
        if (i == 2 && (guessNum == hiddenNum || computerNum == hiddenNum))
        {
            if (hiddenNum == computerNum)
            {
                System.out.println("the hidden number is " + hiddenNum);
                System.out.println("the computer guess is " + computerNum);
                gamePlayer.setComScore(6);
                System.out.println("sorry ! computer guess the right number at the 5th attempts");
                System.out.println("computer have won 6 scores ! you lose! ");
            }
            if (guessNum == hiddenNum)
            {
                System.out.println("the hidden number is " + hiddenNum);
                gamePlayer.setScore(5);
                System.out.println("Congratulations ! you guess the right number at the 6th attempts");
                System.out.println("you have won 5 scores!");
            }
        }
    }

    /**
     * the method for generate situation when human player turn to guess
     * @parameter human takes turn to guess with hidden number and human guess number.
     */
    private void humanGuess(int hiddenNum, int guessNum)
    {
        if (guessNum < min || guessNum > max)
        {
            System.out.println("wrong! you are out of the range! you don't have chance to re-enter guess");

        }
        
        if (guessNum >= min && guessNum <= max )
        {
            if (guessNum > hiddenNum)
            {
                max = guessNum - 1;
                System.out.println("your guess is higher");
            }
            if (guessNum < hiddenNum)
            {
                min = guessNum + 1;
                System.out.println("your guess is lower");
            }
        }
    }

    /**
     * the method have some random numbers and two players take turns to guess number
     */
    private void play()
    {
        int round = 0;
        while (round < 4)
        {
            int hiddenNum = randomNum.getRandomNumber();
            System.out.println("________________________________");
            System.out.println("this is round  " + (round+1));
            System.out.println("________________________________");
            int order = (int)(Math.random() * 2);
            min = 1;
            max = 100;
            int turn = 0;
            int guessNum = 0;
            int computerQ =  1 + (int)(Math.random() * 20);
            switch(order) 
            {
                case 0:
                System.out.println("you take the first trun to guess number");
                while (turn < 3)
                {
                    System.out.println(" now, here is guess  " + (turn+1));
                    System.out.println("************************************************");
                    System.out.println("*       now the range is between " + min + " to "+ max + "        *");
                    System.out.println("************************************************");
                    System.out.println("please input your guess number");
                    guessNum = input.nextInt();
                    int computerG =  1 + (int)(Math.random() * 20);
                    if (computerQ == computerG)
                    {
                        System.out.println("computer give up this round!");
                        break;
                    }
                    if (guessNum < 1 || guessNum > 100 && guessNum != 999)
                    {
                        System.out.println("this is not a valid input, now you have chance to re-enter input");
                        continue;
                    }
                    if (guessNum == 999)
                    {
                        System.out.println("now, you give up this round");
                        break;
                    }
                    humanGuess(hiddenNum,guessNum);
                    int computerNum = min + (int)(Math.random() * (max - min));
                    if (guessNum == hiddenNum)
                    {
                        countScore(turn,guessNum,hiddenNum,computerNum);
                        break; 
                    }
                    computerGuess(hiddenNum,computerNum);
                    if (computerNum == hiddenNum)
                    {
                        countScore(turn,guessNum,hiddenNum,computerNum);
                        break; 
                    }
                    if ( turn == 2 && guessNum != 999)
                        countFinalScore(guessNum,hiddenNum,computerNum);
                    turn++;
                }
                break;
                case 1:
                System.out.println("the computer takes the first trun to guess number");
                while (turn < 3)
                {
                    int computerG =  1 + (int)(Math.random() * 20);
                    if (computerQ == computerG)
                    {
                        System.out.println("computer give up this round!");
                        break;
                    }
                    System.out.println("now, here is guess " + (turn+1));
                    int computerNum = min + (int)(Math.random() * (max - min));
                    computerGuess(hiddenNum,computerNum);
                    if (computerNum == hiddenNum)
                    {
                        countScoreTwo(turn,guessNum,hiddenNum,computerNum);
                        break;               
                    }
                    System.out.println("************************************************");
                    System.out.println("*       now the range is between " + min + " to "+ max + "        *");
                    System.out.println("************************************************");
                    System.out.println("please input your guess number");
                    guessNum = input.nextInt();
                    if ((guessNum < 1 || guessNum > 100) && guessNum != 999)
                    {
                        while(true)
                        {
                            System.out.println("this is not a valid input, now you have chance to re-enter input");                        
                            guessNum = input.nextInt();
                            if (guessNum >= min && guessNum <= max)
                                break;
                        }
                    }
                    if (guessNum == 999)
                    {
                        System.out.println("you give up this round");
                        break;
                    }
                    humanGuess(hiddenNum,guessNum);
                    if (guessNum == hiddenNum)
                    {
                        countScoreTwo(turn,guessNum,hiddenNum,computerNum);
                        break;               
                    }
                    if (turn == 2 && guessNum != 999)
                        countFinalScore(guessNum,hiddenNum,computerNum);
                    turn++;
                }
                break;
            }
            if (round == 3)
            {
                if(gamePlayer.getComScore() > gamePlayer.getScore())
                {
                    System.out.println("computer total score is " + gamePlayer.getComScore()+ " your total score is "+gamePlayer.getScore());
                    System.out.println("The Final winner is computer! sorry, you lose");
                }
                if(gamePlayer.getComScore() < gamePlayer.getScore())
                {
                    System.out.println("computer total score is " + gamePlayer.getComScore()+ " your total score is "+gamePlayer.getScore());

                    System.out.println("The Final winner is you ! congratulations!");
                }
                if(gamePlayer.getComScore() == gamePlayer.getScore())
                {
                    System.out.println("computer total score is " + gamePlayer.getComScore()+ " your total score is "+gamePlayer.getScore());

                    System.out.println("sorry, no one win this game!");
                }
            }
            round++;            
        }
    }

    /**
     * this method for set up new player
     */
    private void setUpPlayer()
    {
        gamePlayer = new Player();
        System.out.println("enter your name");
        String name = input.next().trim();
        if (name.length() >= 1 && name.length() <= 8)
        {
            gamePlayer.setName(name);
            System.out.println("hello, thank you for playing my game!" + gamePlayer.getName() );
        }
        else
        {
            System.out.println("it is not a valid name , please input again");
            setUpPlayer();
        }
    } 

    /**
     * the method for display menu and start play
     */
    public void startPlay()
    {
        System.out.println("Welcome to the gue55ing game, when you don not want to continue playing the game" +
            "you can enter 999 to quit current round of game ");
        setUpPlayer();
        play();
    }
}

#BlueJ package file
dependency1.from=Game
dependency1.to=Player
dependency1.type=UsesDependency
dependency2.from=Game
dependency2.to=RandomNumber
dependency2.type=UsesDependency
editor.fx.0.height=713
editor.fx.0.width=800
editor.fx.0.x=480
editor.fx.0.y=23
objectbench.height=164
objectbench.width=1416
package.divider.horizontal=0.6
package.divider.vertical=0.7193251533742331
package.editor.height=462
package.editor.width=1314
package.editor.x=0
package.editor.y=23
package.frame.height=710
package.frame.width=1440
package.numDependencies=2
package.numTargets=3
package.showExtends=true
package.showUses=true
project.charset=UTF-8
readme.height=58
readme.name=@README
readme.width=47
readme.x=10
readme.y=10
target1.height=50
target1.name=Player
target1.naviview.expanded=true
target1.showInterface=false
target1.type=ClassTarget
target1.width=80
target1.x=480
target1.y=90
target2.height=50
target2.name=Game
target2.naviview.expanded=true
target2.showInterface=false
target2.type=ClassTarget
target2.width=80
target2.x=280
target2.y=210
target3.height=50
target3.name=RandomNumber
target3.naviview.expanded=true
target3.showInterface=false
target3.type=ClassTarget
target3.width=130
target3.x=60
target3.y=90


#BlueJ class context
comment0.target=Player
comment0.text=\n\ Player\ class\ is\ used\ to\ store\ and\ read\ the\ player's\ details,\n\ \n\ @author\ LIN\ HAN\ \n\ @version\ 2018,04,15\n
comment1.params=
comment1.target=Player()
comment1.text=\n\ the\ constructors\ of\ Player\ class\n
comment10.params=playerName
comment10.target=void\ setName(java.lang.String)
comment10.text=\n\ this\ method\ is\ used\ to\ set\ name\ for\ human\ player.\n\ @parameter\ playerName\ \n
comment11.params=currentGuesses
comment11.target=void\ setGuesses(int)
comment11.text=\n\ this\ method\ is\ used\ to\ set\ guesses\ for\ human\ player.\n\ @parameter\ currentGuesses,\ \n
comment12.params=currentComGuess
comment12.target=void\ setComGuess(int)
comment12.text=\n\ this\ method\ is\ used\ to\ set\ guesses\ for\ computer\ player.\n\ @parameter\ currentComGuess,\ \n
comment2.params=newName\ newScore\ newGuess\ newComputerNum\ newComScore
comment2.target=Player(java.lang.String,\ int,\ int,\ int,\ int)
comment2.text=\n\ non-default\ constructor\ of\ Player\ class\n
comment3.params=
comment3.target=int\ getScore()
comment3.text=\n\ this\ method\ is\ used\ to\ get\ the\ human\ player's\ score.\n\ @return\ the\ human\ player's\ score\n
comment4.params=
comment4.target=int\ getComScore()
comment4.text=\n\ this\ method\ is\ used\ to\ get\ the\ computer\ player's\ score.\n\ @return\ the\ computer\ player's\ score\n
comment5.params=
comment5.target=java.lang.String\ getName()
comment5.text=\n\ this\ method\ is\ used\ to\ get\ the\ player's\ name.\n\ @return\ the\ player's\ name\n
comment6.params=
comment6.target=int\ getGuesses()
comment6.text=\n\ this\ method\ is\ used\ to\ get\ the\ human\ player's\ guess\ number.\n\ @return\ the\ human\ player's\ number\n
comment7.params=
comment7.target=int\ getComGuess()
comment7.text=\n\ this\ method\ is\ used\ to\ get\ the\ computer\ player's\ guess\ number.\n\ @return\ the\ computer\ player's\ number\n
comment8.params=currentScore
comment8.target=void\ setScore(int)
comment8.text=\n\ this\ method\ is\ used\ to\ set\ score\ for\ human\ player.\n\ @parameter\ currentScore,\ \n
comment9.params=currentComScore
comment9.target=void\ setComScore(int)
comment9.text=\n\ this\ method\ is\ used\ to\ set\ score\ for\ computer\ player.\n\ @parameter\ currentScore,\ \n
numComments=13


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



#BlueJ class context
comment0.target=RandomNumber
comment0.text=\n\ this\ class\ is\ used\ to\ generate\ random\ number\n\ \n\ @author\ lin\ han\ \n\ @version\ 2018\uFF0C04\uFF0C15\n
comment1.params=
comment1.target=RandomNumber()
comment1.text=\n\ constructor\ of\ this\ class\n
comment2.params=
comment2.target=int\ getRandomNumber()
comment2.text=\n\ method\ for\ generating\ random\ number\ between\ 1\ -\ 100\ (inclusive)\n
numComments=3


/**
 * this class is used to generate random number
 * 
 * @author lin han 
 * @version 2018，04，15
 */
public class  RandomNumber
{
    private int randomNumber;    
    /**
     * constructor of this class
     */
    public  RandomNumber()
    {
       randomNumber = 0;
    }
    
    /**
     * method for generating random number between 1 - 100 (inclusive)
     */
    public int getRandomNumber()
    {
       return 1 + (int)(Math.random() * 100);
    }        
}
------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE:
PURPOSE OF PROJECT:
VERSION or DATE:
HOW TO START THIS PROJECT:
AUTHORS:
USER INSTRUCTIONS:
