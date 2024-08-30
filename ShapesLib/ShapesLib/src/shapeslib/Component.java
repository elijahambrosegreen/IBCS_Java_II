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
         
        int numRectangles = 0;
        Random rand = new Random();
   
        int frame_width = this.getParent().getWidth();
        int frame_height = this.getParent().getHeight();
        
        while (numRectangles < 1000)
        {
            //Squares with black border
            Square     mySquare = 
            new Square(rand.nextInt(frame_width), rand.nextInt(frame_height), 
                          rand.nextInt(50) );
            mySquare.setLineWidth (2.0F);
            mySquare.draw(g);
            numRectangles++;
            //Triangle with red border
            IsoTriangle myTri = 
            new IsoTriangle(rand.nextInt(frame_width), rand.nextInt(frame_height), 
            rand.nextInt(50),rand.nextInt(50) );
            myTri.setOutlineColor(Color.red);
            myTri.setLineWidth(2.0F);
            myTri.draw(g);
            numRectangles++;
            
            //Circle with blue border
            Circle myCircle =
                      new Circle(rand.nextInt(frame_width), rand.nextInt(frame_height), 
                          rand.nextInt(50) );
            myCircle.setLineWidth(2.0F);
            myCircle.setOutlineColor(Color.blue);
            myCircle.draw(g);
            numRectangles++;  
        }
        
    }
}
