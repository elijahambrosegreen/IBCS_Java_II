package dicetester;
/**
 *
 * @author 507606
 */
public class GameModel 
{

    public static final int BONUS = 35;
    public static final int NUM_UPPER_SCORE_CATS = 6;
    public static final int NUM_LOWER_SCORE_CATS = 7;
    public static final int MAX_NUM_TURN = NUM_UPPER_SCORE_CATS + NUM_LOWER_SCORE_CATS;
    
    public GameModel()
    {
        upperScoreCategories = new int[NUM_UPPER_SCORE_CATS +1];
        lowerScoreCategories = new int[NUM_LOWER_SCORE_CATS];
        
        usedUpperScoreCategories = new boolean[NUM_UPPER_SCORE_CATS +1];
        usedLowerScoreCategories = new boolean[NUM_LOWER_SCORE_CATS];
        
        currentTurnNum = 1;
        
        boolean used = true;
    }
    
    public void clearAllUpperScoringCats()
    {
        for (int i = 1; i <= NUM_UPPER_SCORE_CATS; i++)
        {
            upperScoreCategories[i] = 0;
        }
    }
    
    public void clearAllLowerScoringCats()
    {
        for (int i = 0; i < NUM_LOWER_SCORE_CATS; i++)
        {
            lowerScoreCategories[i] = 0;
        }
    }
    
    
    public void clearUsedScoringCats()
    {
        for (int i = 1; i <= NUM_UPPER_SCORE_CATS; i++)
        {
            usedUpperScoreCategories[i] = false;
        }
        for (int i = 0; i < NUM_LOWER_SCORE_CATS; i++)
        {
            usedLowerScoreCategories[i] = false;
        }
    }
    
    public boolean is3ofAKind (Dice myDice)
    {
        int[] freqTable;
        freqTable = myDice.buildFreqTable();
        
        boolean found3ofAKind = false;
        
        for (int i = 1; i<= myDice.getNumSides(); i++)
        {
            if (freqTable[i] >= 3)
            {
                found3ofAKind = true;
            }
        }
        return found3ofAKind;
    }
    
      public boolean is4ofAKind (Dice myDice)
    {
        int[] freqTable;
        freqTable = myDice.buildFreqTable();
        
        boolean found4ofAKind = false;
        
        for (int i = 1; i<= myDice.getNumSides(); i++)
        {
            if (freqTable[i] >= 4)
            {
                found4ofAKind = true;
            }
        }
        return found4ofAKind;
    }
      
     public boolean isYatzhee (Dice myDice)
    {
        int[] freqTable;
        freqTable = myDice.buildFreqTable();
        
        boolean foundYatzhee = false;
        
        for (int i = 1; i<= myDice.getNumSides(); i++)
        {
            if (freqTable[i] >= 5)
            {
                foundYatzhee= true;
            }
        }
        return foundYatzhee;
    }
    
     public boolean isFullHouse (Dice myDice)
     {
        int[] freqTable;
        freqTable = myDice.buildFreqTable();
        
        boolean foundFullHouse = false;
        
        // utilized nested for loop instead of two seperate variables.
           for (int i = 1; i<= myDice.getNumSides(); i++)
        {
            for (int j = 1; j <= myDice.getNumSides(); j++)
                    {
                     if (freqTable[i] == 3 && freqTable [j] == 2)
            {
                       foundFullHouse = true;
            }   
                    }
        }
        
         return foundFullHouse;
     }
     
     
     public boolean isLargeStraight (Dice myDice)
     {
         
         
        int[] freqTable;
        freqTable = myDice.buildFreqTable();
        return freqTable[2] ==1 && freqTable[3] == 1 && freqTable [4] ==1 && freqTable [5] ==1; 
     }
      
    public boolean isSmallStraight (Dice myDice)
    {
        boolean foundSmallStraight;
        
        int[] freqTable;
        freqTable = myDice.buildFreqTable();
        
        for (int i =1; i<= myDice.getNumSides(); i++)
        {
            if (freqTable[i] > 1)
             {
            freqTable[i] = 1;
             }
        
        }
        
        if (freqTable [3] ==1 && freqTable [4] ==1)
        {
            if (freqTable[1] ==1 && freqTable[2] ==1)
            {
                foundSmallStraight = true;
            }
            else 
            {
                foundSmallStraight = false;
            }
            if (freqTable[5] ==1 && freqTable[6] ==1)
            {
                foundSmallStraight = true;
            }
            else 
            {
                foundSmallStraight = false;
            }
             if (freqTable[2] ==1 && freqTable[5] ==1)
            {
                foundSmallStraight = true;
            }
            else 
            {
                foundSmallStraight = false;
            }
          
        }
        else 
        {
            foundSmallStraight = false;
        }
        return foundSmallStraight;
    }
      
    public boolean getUsedUpperScoringCatState(int i)
    {
          return usedUpperScoreCategories[i];
    }
      
    public boolean getUsedLowerScoringCatState(int i)
    {
          
          return usedLowerScoreCategories[i];
    }
      
      
    public void setLowerScoreCat (int index, int score)
    {
        lowerScoreCategories[index] = score;
        
        
    }
    
    public void setUpperScoreCat (int index, int score)
    {
        upperScoreCategories[index] = score;
    }
    
    public void setUsedLowerScoreCat (int index, boolean used)
    {
        usedLowerScoreCategories[index] = used;
    }
    
      public void setUsedUpperScoreCat (int index, boolean used)
    {
        usedUpperScoreCategories[index] = used;
    }
    
    public int addEmUp (Dice myDice)
    {
        int sum = 0;
        
        for (int i = 0; i < myDice.getNumDice(); i++)
        {
            sum += myDice.getDieValue(i);
        }
        return sum;
    }
    
public void nextTurn()
{
    currentTurnNum++;
}


     
        
        
public void updateTotals()
{
    bonus = 0;
    sumUpperScores = 0;
    sumLowerScores = 0;
    grandTotal = 0;
    
    for (int i = 1; i <= NUM_UPPER_SCORE_CATS; i++)
    {
        sumUpperScores += upperScoreCategories[i];
    }
    if (getSumUpperScores() >= 63)
    {
        bonus = 35;
    }
    
    sumUpperScores += getBonus();
    
    for (int i = 0; i < NUM_LOWER_SCORE_CATS; i++)
    {
        sumLowerScores += lowerScoreCategories[i];
    }
    
    grandTotal =  sumUpperScores + sumLowerScores;
    
}     
    
    /**
     * @return the usedUpperScoreCategories
     */
    public boolean[] getUsedUpperScoreCategories() {
        return usedUpperScoreCategories;
    }

    /**
     * @return the usedLowerScoreCategories
     */
    public boolean[] getUsedLowerScoreCategories() {
        return usedLowerScoreCategories;
    }
    /**
     * @return the bonus
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * @return the sumUpperScores
     */
    public int getSumUpperScores() {
        return sumUpperScores;
    }

    /**
     * @return the sumLowerScores
     */
    public int getSumLowerScores() {
        return sumLowerScores;
    }

    /**
     * @return the grandTotal
     */
    public int getGrandTotal() {
        return grandTotal;
    }
    
    public int getCurrentTurnNum()
    {
        return currentTurnNum;
    }
    
    
    private int[]upperScoreCategories;
    private int[]lowerScoreCategories;
    private boolean[] usedUpperScoreCategories;
    private boolean[] usedLowerScoreCategories;
    private int currentTurnNum;
    private int bonus; 
    private int sumUpperScores;
    private int sumLowerScores;
    private int grandTotal;
}
