package conwayslife;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.BLACK;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author 507606
 */
public class ConwaysLife implements MouseListener, ActionListener, Runnable 
{
    int gameSize = 30; 
    boolean[][] cells = new boolean[gameSize][gameSize];
    ConwaysLifePanel panel = new ConwaysLifePanel(cells);
    
    JFrame gameFrame = new JFrame("Elijah & Conway's Game of Life");
    JButton step = new JButton("Step"); 
    JButton start = new JButton("Start"); 
    JButton stop = new JButton("Stop"); 
    JButton newGame = new JButton("New Game"); 
    
    boolean running = false;
 
    Container south = new Container();
    
    public static void main(String[] args) 
    {
      new ConwaysLife();
    }
    
    public ConwaysLife()
    {
        gameFrame.setSize((600/gameSize)*gameSize ,(600/gameSize)*gameSize);  // set to 600 pixels, 
        gameFrame.setLayout(new BorderLayout());
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setVisible(true);
        gameFrame.add(panel, BorderLayout.CENTER);    // creates panel in center container
        panel.setBackground(new Color(0,0,83));
        gameFrame.getContentPane().setBackground( new Color(0,0,83) );
        panel.addMouseListener(this); //creates mouse listener 
        
        //south container 
        south.setLayout(new GridLayout(1,4));
        south.add (step);
        step.addActionListener(this);
        south.add (start);
        start.addActionListener(this);  //action listeners for buttons
        south.add (stop);
        stop.addActionListener(this);
        south.add (newGame);
        newGame.addActionListener(this);

        
        gameFrame.add(south,BorderLayout.SOUTH);
        
        
    }

    @Override
    public void mouseClicked(MouseEvent event) 
    {
       //empty
    }

    @Override
    public void mousePressed(MouseEvent event)
    {
        //empty
    }

    @Override
    public void mouseReleased(MouseEvent event) 
    {
        double width = (double)panel.getWidth() / cells[0].length;
        double height = (double)panel.getHeight() / cells.length; 
        int column = Math.min(cells[0].length - 1, ((int)(event.getX() / width)));
        int row = Math.min(cells.length - 1, ((int)(event.getY() / height)));
        System.out.println(column + "," + row);
        
        cells [row][column] = !cells[row][column]; // uses not statement to fill squares.
        gameFrame.repaint();//repaints
    }

    @Override
    public void mouseEntered(MouseEvent event) 
    {
        //empty
    }

    @Override
    public void mouseExited(MouseEvent event) 
    {
        //empty
    }

    @Override
    public void actionPerformed(ActionEvent event) 
    {
        if (event.getSource().equals(step))
        {
            Step();  //calls step 
        }        
        if (event.getSource().equals(newGame))
        {
           new ConwaysLife();
           gameFrame.dispose();
        }
   
        if (event.getSource().equals(start))
        {
            
            if (running == false)
            {
                running = true;
                Thread t = new Thread(this); //starting new thread to run start button from.
                t.start();
            }
            
            
        } 
        if (event.getSource().equals(stop))
        {
            running = false; //stops
        } 
        
    }
    
    
    
    /*
    row -1 col -1(done) | row -1 col (done) | row -1 col +1 (done)
    
    row col -1 (done)   | ego (r, c) | row col + 1 (done)
    
    row + 1 col - 1 (done)| row +1 col(done)| row +1 col+1 (done)
    
    
    */
    
    
    
    public void Step()
    {
        boolean[][]nextCells = new boolean [cells.length][cells[0].length];
        
        for (int row = 0; row < cells.length; row++)
        {
            for (int col = 0; col < cells[0].length; col++)
            {
                int neighborCount = 0;
                
                if (row > 0 && col > 0 && cells[row-1][col-1] == true) 
                //up & left
                {
                    neighborCount++;
                }
                if (row > 0 && cells[row -1][col] == true)
                //just up
                {
                    neighborCount++;
                }
                if (row > 0 && col < cells[0].length -1 && cells[row -1][col+1] == true)
                //up & right
                {
                    neighborCount++;
                }
                if (col > 0 && cells[row][col -1] == true)
                //left
                {
                    neighborCount++;
                }
                if ( col < cells[0].length -1 && cells[row][col +1] == true)
                //right
                {
                    neighborCount++;
                }
                if (row < cells.length -1  && col > 0 && cells[row+1][col -1] == true)
                //down left 
                {
                    neighborCount++;
                }                
                if (row < cells.length -1  && cells[row +1][col ] == true)
                //just down
                {
                    neighborCount++;
                }
                if (row < cells.length -1  && col < cells[0].length -1 && cells[row+1][col +1] == true)
                //down right
                {
                    neighborCount++;
                }
                
                
                //rules of life. 
                
                if (cells[row][col] == true) //alive!
                {
                    if (neighborCount == 2 || neighborCount == 3)
                    {
                        nextCells[row][col] = true; //alive next time
                    }
                    else 
                    {
                        nextCells[row][col] = false; //death.
                    }
                }
                
                else if(neighborCount == 3)// dead right now
                {
                    nextCells[row][col] = true;
                }
                else 
                {
                    nextCells[row][col] = false;
                }
            }
        }
        
        cells = nextCells;
        panel.setCells(nextCells);
        gameFrame.repaint();
        
    }

    @Override
    public void run() 
    {
        while (running == true)  // while running, step every 250 ms.
        {
            Step();
            try {
                Thread.sleep(250);
            } 
            catch (Exception ex) 
            {
                ex.printStackTrace();
            }
            
        }
    }
}