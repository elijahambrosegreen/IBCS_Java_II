package com.mycompany.gametester;

import java.util.*;

/**
 * @author 507606
 */
public class StartupBust 
{
     private void setUpGame()
   {
       Startup one = new Startup();   // construct three startup objects
       one.setName("Theranos");
       Startup two = new Startup();
       two.setName("Humane AI");
       Startup three = new Startup();
       three.setName("FTX");
       
       startups.add(one);
       startups.add(two);
       startups.add(three);
       
       System.out.println ("Your goal is to sink these three fraudulent startups: ");
       System.out.println ("Theranos, Humane AI, & FTX");
       System.out.println ("SINK EM!");
       
       for (Startup startup : startups)
       {
           ArrayList <String> newLocation = helper.placeStartup(3);
           startup.setLocationCells(newLocation);
       }
   }
     
     private void startPlaying ()
     {
         while (!startups.isEmpty())
         {
             String userGuess = helper.getUserInput("Enter a Coordinate Guess [a0-g6]: ");
             checkUserGuess(userGuess);
         }   
         finishGame();      
     }
     
     private void checkUserGuess (String userGuess)
     {
         numOfGuesses++;
         String result = "miss";
         
         for (Startup startupToTest : startups)
         {
             result = startupToTest.checkYourself(userGuess);
             
             if (result.equals("hit"))
             {
                 break;
             }
             if (result.equals("kill"))
             {
                 startups.remove(startupToTest);
                 break;
             }
         } // end for 
         System.out.println(result);
     }
     
     private void finishGame()
     {
         System.out.println("All of your startups are dead :( Ur stock price is in the gutter!");
         
     }
     
     public static void main(String[] args)
     {
         StartupBust game = new StartupBust();
         game.setUpGame();
         game.startPlaying();
         
     }
     
    private GameHelper helper = new GameHelper();
    private ArrayList<Startup> startups = new ArrayList <Startup>();
    private int numOfGuesses = 0;
}
  
