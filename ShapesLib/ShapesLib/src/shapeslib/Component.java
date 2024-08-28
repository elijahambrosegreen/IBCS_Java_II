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
 * @author velasquezda
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
          Ellipse myEllipse = 
            new Ellipse(rand.nextInt(frame_width), rand.nextInt(frame_height), 
                          rand.nextInt(50), rand.nextInt(50) );
            myEllipse.draw(g);
            numRectangles++;
            
        }
        
    }
}
