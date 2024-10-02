package mychessboard;

import java.awt.Graphics2D;
import javax.swing.JFrame;
import java.awt.Color;

/**
 * @author elijahgreen
 */
public class ChessTester 
{
     public static void main(String[] args) 
    {
        //creates new chessboard object.
       JFrame frame = new JFrame();
        
        // Set the frame's initial size
        frame.setSize(50*9,50*9);
        
        //Set the frame's title
        frame.setTitle("Chess Board (elijahgreen)");
        
        // Tell the Java runtime to close the frame when the program is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Construct an instance (object) of a new component
        Component component = new Component();
        
        // Tell the frame to add the compnent to itself
        frame.add(component);
        
        // Tell Java to make the frame and its contents visible
        frame.setVisible(true);
    }
}
