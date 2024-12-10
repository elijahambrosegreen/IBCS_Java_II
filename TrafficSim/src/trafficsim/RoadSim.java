
package trafficsim;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class RoadSim extends JPanel {
    
    final int LANE_HEIGHT = 120;
    final int ROAD_WIDTH = 1000;
    ArrayList<VehicleSim> cars = new ArrayList<VehicleSim>();
    
    
    
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.WHITE);
        
        for(int i = LANE_HEIGHT; i < (LANE_HEIGHT*4); i+= LANE_HEIGHT)
        {
            for (int a = 0; a < getWidth(); a += 40)
            {
                g.fillRect(a, i, 30, 5);
            }
        }
        
        for (int a = 0; a < cars.size(); a++)
        {
            System.out.println("painting road");
            cars.get(a).paintMe(g);
        }
    }
    
    public RoadSim()
    {
        super();
    }
    
    public void addCar (VehicleSim v)
    {
        cars.add(v);
    }
    
    public void paintRoads()
    {
        
    }
    
     public void step()
    {
        for (int a = 0; a < cars.size(); a++)
        {
            VehicleSim v = cars.get(a);
            v.setX(v.getX() + v.getSpeed());
            
            
            if (v.getX() > ROAD_WIDTH)
            {
                v.setX(0);
            }
        }
    }
     
     public boolean collision (int x , int y, int width, VehicleSim v)
     {
         boolean collide = false;
         for (int a = 0; a < cars.size(); a++)
         {
             VehicleSim u = cars.get(a);
             if (y == u.getY()) // if in same lane, continue checks
             {
                 if (u.equals(v)== false) // if not checking self.
                 {
                     if (v.getX() < u.getX() + u.getWidth() && // my left is left of his right
                             v.getX() + v.getWidth() > u.getX()) //my right is right of his left
                     {
                         return true;
                     }
                 }
             }
             
         }
         return collide;
     }
    
}
