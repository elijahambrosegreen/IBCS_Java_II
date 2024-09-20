package com.mycompany.gametester;

import java.util.*;

/**
 * @author 507606
 */
public class StartupBust 
{
     private void setUpGame()
   {
       Startup one = new Startup();   // construct three startup objects, give them names and put them in the arraylist.
       one.setName("Apple");
       Startup two = new Startup();
       two.setName("Microsoft");
       Startup three = new Startup();
       three.setName("Nvidia");                
       
       startups.add(one);
       startups.add(two);
       startups.add(three);
       
       System.out.println ("Your goal is to sink these three very small and insignifigant startups: ");
       System.out.println ("Apple, Microsoft,& Nvidia");                               //prints brief instructions for the player.
       System.out.println ("SINK EM!");
       
       for (Startup startup : startups)
       {
           ArrayList <String> newLocation = helper.placeStartup(3); //creates our array list.
           startup.setLocationCells(newLocation);// Calls setter method on location.
       }
   }
     
     private void startPlaying ()
     {
         while (!startups.isEmpty()) //repeat while argument that all startups are empty is NOT true.
         {
             String userGuess = helper.getUserInput("Enter a Coordinate Guess [a0-g6]: "); // gets user input.
             checkUserGuess(userGuess); //calls checkUserGuess.
         }   
         finishGame();    //call finishgame method.  
     }
     
     private void checkUserGuess (String userGuess)
     {
         numOfGuesses++; //increment user guesses. 
         String result = "miss"; //assumes miss unless told otherwise.
         
         for (Startup startupToTest : startups) //repeat with each startup in list.
         {                                      
             result = startupToTest.checkYourself(userGuess);//calls checkYourself to check user guess.
             
             if (result.equals("hit"))
             {
                 break; //exits loop early.
             }
             if (result.equals("kill"))
             {
                 startups.remove(startupToTest); //dead ship to be removed from startups list.
                 break;
             }
         } // end for 
         System.out.println(result); //prints result
     }
     
     private void finishGame()
     {
         System.out.println("All of your startups are dead :( Ur stock price is in the gutter!"); //Prints message detailing how the player did. 
         
     }
     
     public static void main(String[] args)
     {
         StartupBust game = new StartupBust(); //creates the game object. 
         game.setUpGame(); //tells game object to set up game.
         game.startPlaying(); //tells game object to start main gameplay.
         
     }
     
    private GameHelper helper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList <Startup>(); //Declare and initialize instance variables.
    private int numOfGuesses = 0;
}
  
