/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trafficsim;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 507606
 */
public class SportsCarSim extends VehicleSim{
    
     public void paintMe(Graphics g)
    {
        g.setColor(Color.RED);
        g.fillRect(getX(), getY(), width, height);
    }
    
    public SportsCarSim( int newx, int newy)
    {
        super(newx, newy);
        width = 40;
        height = 20;
        speed = 12;
    }
    
}
