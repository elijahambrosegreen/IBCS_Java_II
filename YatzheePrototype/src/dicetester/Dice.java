package dicetester;

import java.util.Random;

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
           myDice = null;
        }
        // creates a set of dice given the parameters passed in. 
        public Dice (int numDice, int numSides)
        {
            
            this.numDice = numDice;
            this.numSides = numSides;
            
            //create an array to hold dice.
            this.myDice = new Die[numDice];
            
            //loop though array, creating each individual die.
            for (int i = 0; i<numDice; i++)
            {
                myDice[i] = new Die(numSides);
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
        
        public int rollDie(int i)
        {
            //index into the rollArray & reroll that die.
            return myDice[i].roll(rand); 
        }
        
        public int rollDice()
        {
                int sum = 0;
                for (int i = 0; i <getNumDice(); i++)
                {
                    sum += myDice[i].roll(rand);
                }
                return sum;
        }
        /**
         * obtains the value of a single die in the array. 
         * @param dieNum indicates which die to get val for. 
         * @return the val of the die. 
         */
        public int getDieValue(int i)
        {
            return myDice[i].getValue();   
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

    
    public int getNumDice()
    {
        return numDice;
    }
    
     public int getNumSides()
    {
        return numSides;
    }

    public int[] buildFreqTable() 
    {
        int [] freqTable = new int [getNumSides() +1];
                
        
        /**
         * get val of each die in set of dice 
         * use the val to index into the freq table array & 
         * increment the count for that roll val in the table.
         */
        for (int i = 0; i < getNumDice(); i++)
        {
            freqTable[myDice[i].getValue()]++;
        }
        return freqTable;
    }
    
    
    
    private int numDice;
    private int numSides;
    private Die [] myDice;
    private Random rand;
    
}
