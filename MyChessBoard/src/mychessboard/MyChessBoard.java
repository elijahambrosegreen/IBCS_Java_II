package mychessboard;

import java.awt.Color;
import static java.awt.Color.black;
import static java.awt.Color.white;
import java.awt.Graphics;
import shapeslib.Square;

/**
 * @author 507606
 */
public class MyChessBoard {
    
    final int ROW_SIZE = 8;
    final int COL_SIZE = 8;
    private final Square[][] board; // 2D array for the chess board

    public MyChessBoard() {
        board = new Square[ROW_SIZE][COL_SIZE]; // Initializes the 2D array

        for (int i = 0; i < ROW_SIZE; i++) 
        {
            for (int j = 0; j < COL_SIZE; j++) 
            {

                // Alternate colors based on row and column, testing evenness. 
                if ((i + j) % 2 == 0) 
                {
                    board[i][j] = new Square(j * 50 + 10, i * 50 + 10, 50);
                    board[i][j].setFillColor(Color.white);
                   // board [i][j].setOutlineColor(Color.black);
                } else 
                    
                {
                    board[i][j] = new Square(j * 50 + 10, i * 50 + 10, 50);
                    board[i][j].setFillColor(Color.darkGray);
                }
                
                board[i][j].setFilled(true);
                board[i][j].setLineWidth(1.0F);
                board[i][j].setOutlineColor(Color.black);
            }
        }
    }

    public void draw(Graphics g) {
        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < COL_SIZE; j++) {
                board[i][j].draw(g); // Draw each square
               if (i < 2 )
               {
                   Rook rook1 = new Rook(j * 50 + 25, i * 50 + 25,25,25);
                rook1.draw(g);
    
               }
               else if (i > 5)
               {
                   Rook rook2 = new Rook(j * 50 + 25, i * 50 + 25,25,25);
                rook2.draw(g);

               }
            }
        }
        
         
        
    }
}
