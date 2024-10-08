/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.factorprog;

/**
 *
 * @author 507606
 */
public class FactorProg 
{
    public static void main(String[] args) 
    {
        int num = 140;
        int f = 1;
        int factors = 0;
        
        for (;f*f<=num; f++)
        {
            if (num%f == 0)
            {
                int d = num/f;
                System.out.println(num + " = " + f +"*" + d );
            }
            if (f == 1)
            {
                factors = factors + 0;
            }
            else if (f == num/f) 
            {
            factors++;   
            }
            else 
            {
                factors +=2;
            }//end if 
            f++;
        }//end for 
        
        System.out.println(num + " has " + factors + " factors");
    }//ends method
}//ends class
