package mychessboard;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import shapeslib.Rectangle;
import shapeslib.Shape2D;
import shapeslib.Square;

/*
 * @author 507606
 */
public class Rook extends Shape2D
{
    
    public Rook()
    {
        super();

    } 
    
    public Rook(int x, int y, int width, int height)
    {
      super(x, y, width, height);
    }
    
     /**
     * Secondary Constructor for rectangle class, with lineWidth, Color and fill.
     * @param x
     * @param y
     * @param width
     * @param height
     * @param outlineColor
     * @param fillColor
     * @param filled
     * @param lineWidth 
     */
    
    public Rook (int x, int y, int width, int height, Color outlineColor, Color fillColor, boolean filled, float lineWidth) 
    {
        super (x,y,width,height,outlineColor,fillColor,filled,lineWidth);
    }

    @Override
    public void draw (Graphics g)
    {
        
        Graphics2D g2 = (Graphics2D) g;
        java.awt.Rectangle piece1 = new java.awt.Rectangle(getX(), getY(), 
                getWidth(), getHeight());
        g2.draw(piece1);
        
         if (isFilled())
       {
           g2.setColor(getFillColor());
           g2.fill(piece1);
           g2.draw(piece1); 
           g2.setColor(getOutlineColor());
           g2.setStroke(new BasicStroke(getLineWidth()));
       }

    }
    
    
}
