package shapeslib;


import shapeslib.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author velasquezda
 */
public class Square extends Rectangle {
    public Square(int x, int y, int size)
    {
      super(x, y, size, size);
    }
    
    public Square()
    {
        super();

    }
}
