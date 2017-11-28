package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cages {

    private Position pos;
    private Rectangle border;
    private Rectangle cage;

    public Cages(int col, int row){
        pos = new Position(col,row);
        cage = new Rectangle((col)*Field.CELLPIXELS, (row+4)*Field.CELLPIXELS,2*Field.CELLPIXELS,Field.CELLPIXELS);
        border = new Rectangle((col)*Field.CELLPIXELS, (row+4)*Field.CELLPIXELS,2*Field.CELLPIXELS,Field.CELLPIXELS);
        cage.setColor(Color.RED);
        cage.fill();
        border.setColor(Color.BLACK);
        border.draw();
    }

}
