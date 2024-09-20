/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shapeslib;


import javax.swing.JFrame;

/**
 *
 * @author velasquezda, edited by greene
 */
public class ComponentViewer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // Construct an instance of a JFrame
        JFrame frame = new JFrame();
        
        // Set the frame's initial size
        frame.setSize(500 ,500);
        
        //Set the frame's title
        frame.setTitle("1000 Random Shapes (elijahgreen)");
        
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
