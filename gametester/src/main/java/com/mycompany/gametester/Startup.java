package com.mycompany.gametester;
import java.util.*;

/**
 * @author elijahgreen
 */
public class Startup {

    private ArrayList<String> locationCells;
    private String name;
    
public void setLocationCells (ArrayList<String> loc)
{
locationCells = loc;
}

public void setName (String n)
{
    name = n;
}

public String checkYourself(String userInput){
 String result = "miss";
 int index = locationCells.indexOf(userInput);
 
         if (index >=0){
                 locationCells.remove(index);
                 
         if (locationCells.isEmpty()){
             result = "kill";
             System.out.println ("OUCH! You sunk " + name + "  :( ");
         }else{
             result = "hit";
         }//end if
     } //ends outer if  //System.out.println(result);
    return result;
  } //end method          
 } //end class



