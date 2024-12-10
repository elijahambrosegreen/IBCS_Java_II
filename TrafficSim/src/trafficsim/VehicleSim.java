/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trafficsim;

import java.awt.Graphics;

/**
 *
 * @author 507606
 */
public class VehicleSim 
{

    
    private int x;
    private int y;      
    int width;
    int height;
    int speed;
    
    public VehicleSim (int newx, int newy)
    {
        x = newx;
        y = newy;
    }
    
    public void paintMe(Graphics g)
    {
        
    } 
    
    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int newx) {
        x = newx;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int newy) {
        y = newy;
    } 
    
    public int getSpeed()
    {
        return  speed;
    }
    
    public int getWidth()
    {
        return width;
    }
    
}
