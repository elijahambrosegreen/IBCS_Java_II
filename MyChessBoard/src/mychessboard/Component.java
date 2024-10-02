/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mychessboard;

import shapeslib.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
/*
 * @author elijahgreen
 */
public class Component extends JComponent
{
    @Override
    public void paintComponent(Graphics g)
    {
           MyChessBoard board = new MyChessBoard();
           board.draw(g);
 
    }
    
    
}
