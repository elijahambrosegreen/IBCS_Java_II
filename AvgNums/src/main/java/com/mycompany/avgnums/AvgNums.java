package com.mycompany.avgnums;
import java.util.Scanner;

 // @author elijahgreen

public class AvgNums 
{
    public static void main(String[] args) 
    {
            double count = 0;
            double total = 0;
            
            int [] Stock = new int[1000];
            
            Stock[10]=20;
            Stock[15]=40;
  
            for (int i=0; i<Stock.length; i++){
           
            if (Stock[i] > 0)
            {
                count ++;
                total +=Stock[i];
            }
            
         }//ends for
            if (count > 0.0){
               System.out.println("The average is " + total/count);
            }
            else {
               System.out.println("no non zero values");
     }//ends else 
   }//ends method
}//ends class
