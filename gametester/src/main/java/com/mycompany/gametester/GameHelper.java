package com.mycompany.gametester;
import java.util.Scanner;
/**
 * @author 507606
 */
public class GameHelper 
{
    public int getUserInput(String prompt)
    {
        System.out.print(prompt+ " ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
