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
public class SUVSim extends VehicleSim{
     public void paintMe(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.fillRect(getX(), getY(), width, height);
    }
    
    public SUVSim (int newx, int newy)
    {
        super(newx, newy);
        width = 60;
        height = 30;
        speed = 10;
    }
    
    
}
