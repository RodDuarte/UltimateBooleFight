package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Position {

    private int col;
    private int row;
    private Rectangle rectangle;


    public Position(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public Position getPosition() {
        return this;
    }

    public void setPos(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    //KEYBOARD EVENT!!

    /*public void moveInDirection(Keyboard direction) {

        switch (direction) {

            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
        }

    }



    public boolean equals(Position pos) {
        return this.col == pos.getCol() && this.row == pos.getRow() ? true : false;
    }

    public void moveUp() {
        rectangle.translate((getCol())*Field.CELLPIXELS,(getRow()-1)*Field.CELLPIXELS);
    }

    public void moveDown() {
        rectangle.translate((getCol())*Field.CELLPIXELS,(getRow()+1)*Field.CELLPIXELS);
    }

    public void show() {
        rectangle.fill();
    }

    public void hide() {

        rectangle.delete();
    }
*/

}
