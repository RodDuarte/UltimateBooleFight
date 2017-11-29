package org.academiadecodigo.bootcamp.Hitables.Characters;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Hitables.Hitables;
import org.academiadecodigo.bootcamp.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Character implements Hitables{

    private int col;
    private int row;
    private Position position;
    private Rectangle person;
    //private Characters characters;

    public Character (int col, int row){
        //this.characters = characters;
        this.col = col;
        this.row = row;
        this.position = new Position(col,row);
        person = new Rectangle(col*Field.CELLPIXELS, row*Field.CELLPIXELS, Field.CELLPIXELS, Field.CELLPIXELS);
        person.setColor(Color.ORANGE);
        person.fill();
    }

    public void moveForward(){
        if(position.getCol() >= 0 && position.getCol() <= 19) {
            if (position.getCol() == 0) {
                person.delete();
            }
            position.moveLeft();
            person.translate(-Field.CELLPIXELS,0);
        }
    }

}
