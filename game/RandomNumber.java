
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