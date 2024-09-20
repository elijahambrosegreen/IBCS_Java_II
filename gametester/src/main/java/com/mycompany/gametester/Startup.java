package com.mycompany.gametester;
import java.util.*;

public class Startup
{
   
public void setLocationCells (ArrayList<String> loc) //setter method that updates startup location. 
{
locationCells = loc;
}

public void setName (String n) //basic setter method.
{
    name = n;
}

public String checkYourself(String userInput)
{
 String result = "miss";
 int index = locationCells.indexOf(userInput);
 
         if (index >=0)
     {
         locationCells.remove(index); //using remove method to delete entry.
                 
         if (locationCells.isEmpty())  //using is empty to check if locations have all been guessed.
         {
             result = "kill";
             System.out.println ("OUCH! You sunk " + name + "  :( "); //dialogue when ship is sank.
         }//end if 
         else
         {
             result = "hit";
         }//end if
     }// end outer if
    return result; //returns hit miss or kill.
  } //end method          

    private ArrayList<String> locationCells; //arraylist of cell locs.
    private String name; // startup name
 } //end class



