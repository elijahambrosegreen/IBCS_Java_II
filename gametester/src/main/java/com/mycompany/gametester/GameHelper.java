package com.mycompany.gametester;
import java.util.*;
/**
 * @author 507606
 */
public class GameHelper 
{
    public String getUserInput(String prompt)
    {
        System.out.print(prompt+ " ");
        Scanner scanner = new Scanner(System.in); //creates new scanner for user input. 
        return scanner.nextLine().toLowerCase();
    }
    
    public ArrayList <String> placeStartup(int startupSize)
    {
        //holds index grid from 0-48
        
        int []startupCoords = new int [startupSize]; 
        int attempts = 0;
        boolean success = false; //initialize with zero attempts, false for success
        
        startupCount++;
        int increment = getIncrement();
        
        while (!success & attempts++ < MAX_ATTEMPTS)
        {
            int location = random.nextInt(GRID_SIZE);
            
            for (int i = 0; i < startupCoords.length; i++) //loop until i is greater than the length of the grid.
            {
                startupCoords[i] = location; //puts location in index for array.
                location += increment; 
            }// end for 
            if (startupFits (startupCoords, increment))
            {
                success = coordsAvailable(startupCoords);
            }//end if 
        }//end while
        savePositionToGrid(startupCoords); // if coords fit, save.
        ArrayList<String> alphaCells = convertCoordsToAlphaFormat (startupCoords);
        return alphaCells;
    }// end method
    
    private boolean startupFits (int[] startupCoords, int increment)
    {
        int finalLocation = startupCoords [startupCoords.length - 1];
        
        if (increment == HORIZONTAL_INCREMENT)
        {
            return calcRowFromIndex(startupCoords[0])== calcRowFromIndex(finalLocation);
        } //end if 
        else
        { 
                return finalLocation < GRID_SIZE;
        }//end else 
    }// end method
    private boolean coordsAvailable (int [] startupCoords) 
    {
        for (int coord : startupCoords) //checks potential positions
        {
            if (grid[coord] != 0) //if already taken, return false.
            {
                return false;
            }//end if 
        }//end for 
        return true;
    }// end method
    
    private void savePositionToGrid (int[] startupCoords)
    {
        for (int index : startupCoords)
        {
            grid [index] = 1; //updates index val to 1, or used.
        }//end for 
    }// end method
    
    private ArrayList <String> convertCoordsToAlphaFormat (int[] startupCoords)
    {
        ArrayList<String> alphaCells = new ArrayList<String>(); //creates arraylist of alphabetical coordinates.
        for (int index : startupCoords)
        {
            String alphaCoords = getAlphaCoordsFromIndex(index); //creates a0 type coordinates.
            alphaCells.add(alphaCoords);
        } //end for 
        return alphaCells;
    }// end method
    
    private String getAlphaCoordsFromIndex(int index)
    {
        int row = calcRowFromIndex(index); //get row val.
        int column = index % GRID_LENGTH; // get num column val.
        String letter = ALPHABET.substring(column, column + 1); // conv to alphanumeric
        return letter + row;
    }// end method
    
    private int calcRowFromIndex(int index)
    {
        return index / GRID_LENGTH;
    }// end method
    private int getIncrement()
    {
        if (startupCount % 2 == 0) //if even startup, (mod zero), place horizontal, else place vertically.
        {
            return HORIZONTAL_INCREMENT;
        }//end if 
        else 
        {
            return VERTICAL_INCREMENT;
        }//end else 
    }// end method
            private static final String ALPHABET = "abcdefg";
            private static final int GRID_LENGTH = 7;
            private static final int GRID_SIZE = 49; //sets grid size to 49.
            private static final int MAX_ATTEMPTS = 200;
            static final int HORIZONTAL_INCREMENT = 1;
            static final int VERTICAL_INCREMENT = GRID_LENGTH;
            
            private final int[] grid = new int[GRID_SIZE]; //moved private instance variables to bottom of src.
            private final Random random = new Random();
            private int startupCount = 0;
}//end class
