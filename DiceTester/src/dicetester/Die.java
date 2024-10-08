package dicetester;

import java.util.Random;

/*
 * * @author 507606
 */
public class Die 
{
    private int value;
    private int numSides;
    int getValue;
    
    public Die(int numSides)
    {
        this.numSides = numSides;
    }
        
    public int roll()
    {
        Random generator = new Random(); 
        value = generator.nextInt(numSides)+1;
        return value;
        
    }
    
    public int getValue()
    {
        return value;
    }

    /**
     * @return the numSides
     */
    public int getNumSides() 
    {
        return numSides;
    }
            
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
