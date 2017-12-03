package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Cages {

    private Position pos;
    private Picture cages;

    public Cages(){
        pos = new Position(16,3);
        cages = new Picture(16*Field.CELLPIXELS,3*Field.CELLPIXELS,"cages.png");
        cages.draw();
    }

    public void deleteCages(){

        cages.delete();
    }

    public void moveCages(){
        if(pos.getCol()!= 1) {
            pos.moveLeft();
            cages.translate(-Field.CELLPIXELS, 0);
        }

    }

    public Position getPos(){
        return pos;
    }

}
