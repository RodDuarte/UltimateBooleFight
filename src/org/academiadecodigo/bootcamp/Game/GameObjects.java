package org.academiadecodigo.bootcamp.Game;

import org.academiadecodigo.bootcamp.Field;
import org.academiadecodigo.bootcamp.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class GameObjects{

    private Position position;
    private Rectangle object;

     public GameObjects(int col, int row){
         this.position = new Position(col,row);
         object = new Rectangle(col*Field.CELLPIXELS, row*Field.CELLPIXELS, Field.CELLPIXELS, Field.CELLPIXELS);
     }

    public Position getPosition() {
        return position;
    }

    public void moveForward(){
        if(getPosition().getCol() >= -1 && getPosition().getCol() <= 20) {
            if (getPosition().getCol() == -1) {
                object.delete();
            }
            getPosition().moveLeft();
            object.translate(-Field.CELLPIXELS,0);
        }
    }

    public void setColor(Color color){
        object.setColor(color);
    }

    public void fill(){
        object.fill();
    }

    public void delete(){
        object.delete();
    }
}
