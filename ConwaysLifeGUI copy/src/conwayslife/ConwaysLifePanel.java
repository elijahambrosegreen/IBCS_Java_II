package conwayslife;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
/**
 * @author 507606
 */
public class ConwaysLifePanel extends JPanel
{
    boolean [][] cells;
    double width; 
    double height;
    
    public ConwaysLifePanel (boolean [][] in )
    {
        cells = in;
    }
    
    public void setCells (boolean [][] newCells)
    {
        cells = newCells;
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        //g.drawLine(0, 0, 2000, 2000);
        width = (double)this.getWidth() / cells[0].length;
        height = (double)this.getHeight() / cells.length;
        
        
        g.setColor(Color.WHITE);
        
        for (int row = 0; row < cells.length; row++ )
        {
            for (int column = 0; column < cells[0].length; column++)
            {
                if (cells[row][column] == true)
                {
                    g.fillRect((int)Math.round(column*width), (int)Math.round(row*height), (int)(width)+1, (int)(height)+1);
                }
            }
        }
        
        g.setColor(Color.WHITE);
        for (int x = 0; x < cells[0].length; x++)
        {
           g.drawLine((int)Math.round(x*width), 0, (int)Math.round(x*width), this.getHeight());
        }
         for (int y = 0; y < cells.length; y++)
        {
           g.drawLine(0, (int)Math.round(y*height), this.getWidth(),(int)Math.round(y*height));
        }

         
    }
    
}
