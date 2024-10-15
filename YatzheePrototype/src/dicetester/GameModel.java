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
        upperScoreCategories = new int[NUM_UPPER_SCORE_CATS ];
        lowerScoreCategories = new int[NUM_LOWER_SCORE_CATS ];
        
        usedUpperScoreCategories = new boolean[NUM_UPPER_SCORE_CATS];
        usedLowerScoreCategories = new boolean[NUM_LOWER_SCORE_CATS];
        
        currentTurnNum = 1;
    }
    
    public void clearAllUpperScoringCats()
    {
        for (int i = 0; i < NUM_UPPER_SCORE_CATS; i++)
        {
            upperScoreCategories[i]=0;
        }
    }
    
    public void clearAllLowerScoringCats()
    {
        for (int i = 0; i < NUM_LOWER_SCORE_CATS; i++)
        {
            lowerScoreCategories[i]=0;
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
    
    public void setLowerScoreCat (int index, int score)
    {
        lowerScoreCategories[index] = score;
    }
    
    public void setUsedLowerScoreCat (int index, boolean used)
    {
        usedLowerScoreCategories[index] = used;
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
    
     
    
    
    private int[]upperScoreCategories;
    private int[]lowerScoreCategories;
    private boolean[] usedUpperScoreCategories;
    private boolean[] usedLowerScoreCategories;
    private int currentTurnNum;
}
