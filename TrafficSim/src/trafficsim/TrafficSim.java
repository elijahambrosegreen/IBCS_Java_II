package trafficsim;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TrafficSim implements ActionListener, Runnable
{
    JFrame frame = new JFrame("Traffic Simulation");
    RoadSim road = new RoadSim();
    //south container
    JButton start = new JButton ("Start");
    JButton stop = new JButton ("Stop");
    JLabel throughPut = new JLabel ("Throughput: ");
    Container south = new Container ();
    
    //west container
    JButton semi = new JButton ("Add Semi Truck");
    JButton SUV = new JButton ("Add SUV");
    JButton sports = new JButton ("Add Sports Car");
    
    Container west = new Container();
    
    
    boolean running = false; 
    int carCount = 0;
    long startTime = 0;
    
    public TrafficSim()
    {
        frame.setSize(1000    ,550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.add(road, BorderLayout.CENTER);
        
        south.setLayout(new GridLayout(1,2));
        south.add(start);
        start.addActionListener(this);
        south.add(stop);
        stop.addActionListener(this);
        frame.add(south, BorderLayout.SOUTH);
        
        
        west.setLayout(new GridLayout (3,1));
        west.add(semi);
        semi.addActionListener(this);
        west.add(SUV);
        SUV.addActionListener(this);
        west.add(sports);
        sports.addActionListener(this);
        frame.add(west, BorderLayout.WEST);
        
        
       // SemiSim testSemi = new SemiSim(10,70);
       // SUVSim testSUV = new SUVSim(10, 250);
        //SportsCarSim testSport = new SportsCarSim(10, 430);
        
     //   road.addCar(testSemi);
     //   road.addCar(testSUV);
        //road.addCar(testSport);
        frame.repaint();
    }
    
    
    
    public static void main(String[] args) 
    {
        new TrafficSim();
        
    }

    @Override
    public void actionPerformed(ActionEvent event) 
    {
        if (event.getSource().equals(start))
        {
            if (running == false)
            {
                  running = true;
                  Thread t = new Thread(this);
                  t.start();
            }
        }
        if (event.getSource().equals(stop))
        {
            running = false;
        }
        
        if (event.getSource().equals(semi))
        {
            SemiSim semi = new SemiSim (0, 30);
            road.addCar(semi);
            for (int x = 0; x < road.ROAD_WIDTH; x+= 20)
            {
                 for (int y = 30; y < 480; y += 120)
                {
                    semi.setX(x);
                    semi.setY(y);
                    System.out.println(x + " " + y);
                    if (road.collision(x, y, semi.getWidth(), semi) == false)
                    {
                        System.out.println("repaint");
                        frame.repaint();
                        return;
                    }
                }
            } 
       }
        if (event.getSource().equals(SUV))
        {
            SUVSim SUV = new SUVSim (0, 30);
            road.addCar(SUV);
            for (int x = 0; x < road.ROAD_WIDTH; x+= 20)
            {
                 for (int y = 30; y < 480; y += 120)
                {
                    SUV.setX(x);
                    SUV.setY(y);      
                    if (road.collision(x, y, SUV.getWidth(), SUV) == false)
                    {
                        frame.repaint();
                        return;
                    }
                }
          }
       }
        
        if (event.getSource().equals(sports))
        {
            SportsCarSim sports = new SportsCarSim (0, 30);
            road.addCar(sports);
            for (int x = 0; x < road.ROAD_WIDTH; x+= 20)
            {
                 for (int y = 30; y < 480; y += 120)
                {
                    sports.setX(x);
                    sports.setY(y);      
                    if (road.collision(x, y, sports.getWidth(), sports) == false)
                    {
                        frame.repaint();
                        return;
                    }
                }
          }
       }
    }

    
    @Override
    public void run() 
    {
       while (running == true)
       {
           road.step();
           frame.repaint();
           try { 
               Thread.sleep(100);
           }
           catch (Exception ex)
           {
               ex.printStackTrace();
           }
       }
        
    }


}
