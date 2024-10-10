package dicetester;
/**
 * a class that simulates the rolling of dice. 
 * @author 507606
 */
public class Dice 
{
    
    //creates empty set of dice. 
    
        public Dice ()
        {
           numDice = 0; 
           numSides = 0; 
           rollArray = null;
        }
        // creates a set of dice given the parameters passed in. 
        public Dice (int numDice, int numSides)
        {
            
            this.numDice = numDice;
            this.numSides = numSides;
            
            //create an array to hold dice.
            this.rollArray = new Die[numDice];
            
            //loop though array, creating each individual die.
            for (int i = 0; i<numDice; i++)
            {
                rollArray[i] = new Die(numSides);
            }
            
            
        }
        /**
         * rolls the dice.
         * @return the sum of all the dice. 
         */
        
        public int roll()
        {
            int sum = 0;
            //loops through array, rerolls every die for each array element. 
            for (int j = 0; j<numDice; j++)
            {
               sum += rollDie(j);
            }
            return sum;
        }
        
        /**
         * rolls a single die in the set of dice.
         * @param dieNum the die element in the array to roll
         * @return the number that was rolled.
         */
        
        public int rollDie(int dieNum)
        {
            //index into the rollArray & reroll that die.
            return rollArray[dieNum].roll(); 
        }
        /**
         * obtains the value of a single die in the array. 
         * @param dieNum indicates which die to get val for. 
         * @return the val of the die. 
         */
        public int getDieValue(int dieNum)
        {
            return rollArray[dieNum].getValue();   
        }     
        /**
         * sums all of the dice.
         * @return the sum of all dice.
         */
        public int addEmUp()
        {
            int sum = 0;
            //loops through array, summing the value of all dies rolled. 
            for (int k = 0; k<numDice; k++)
            {
               sum += getDieValue(k);
            }
            return sum;
        }

    private int numDice;
    private int numSides;
    private Die [] rollArray;
    
    
    public int getNumDice()
    {
        return numDice;
    }
    
     public int getNumSides()
    {
        return numSides;
    }
    
    
    
}
