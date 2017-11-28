package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Bull {

    private Position pos;
    private Rectangle rectangle;

    public Bull(){

        pos = new Position(0,6);
        rectangle = new Rectangle(0, 6*Field.CELLPIXELS,Field.CELLPIXELS,Field.CELLPIXELS);
        rectangle.setColor(Color.BLACK);
        rectangle.fill();

    }

}
