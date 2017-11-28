package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Position {

    private int col;
    private int row;

    public Position(int col, int row){
        this.col = col;
        this.row = row;
    }

    public void genPosition(int width, int height) {
        this.col = (int) (Math.random() * width);
        this.row = (int) (Math.random() * height);
    }

    public void moveUp() {
        //  if (row > 0) {
        this.row --;
        //}
    }

    public void moveDown() {
        // if (row < TestField.widht - 1) {
        this.row++;
        //}
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}


/*public class Position {

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



}*/
