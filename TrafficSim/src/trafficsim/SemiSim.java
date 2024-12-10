package trafficsim;

import java.awt.Color;
import java.awt.Graphics;

public class SemiSim extends VehicleSim
{
    public void paintMe(Graphics g)
    {
        g.setColor(Color.BLUE);
        g.fillRect(getX(), getY(), width, height);
    }
    
    public SemiSim (int newx, int newy)
    {
        super(newx, newy);
        width = 60;
        height = 40;
        speed = 5;
    }
    
    
}
