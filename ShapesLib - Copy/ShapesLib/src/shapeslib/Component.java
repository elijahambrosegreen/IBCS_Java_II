/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shapeslib;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JComponent;

/**
 *
 * @author velasquezda edited by elijahgreen
 */
public class Component extends JComponent
{
    @Override
    public void paintComponent(Graphics g)
    {
         
         int [][]eightbyeight = new int[8][8];
                for (int[] element : eightbyeight)
                {
                 Square mySquare = 
                 new Square(10,10,50); 
                 mySquare.setLineWidth (1.0F);
                 mySquare.draw(g); 
                 
                } 
        }
        
    }
}
