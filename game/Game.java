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
