package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {

    private int cols;
    private int rows;
    private Rectangle rectangle;
    private Line line;
    public static final int PADDING_UP = 300;
    public static final int CELLPIXELS = 60;


    public Field(int cols, int rows, boolean road){
        this.cols = cols;
        this.rows = rows;
        if(road == false){
            rectangle = new Rectangle(0,0,cols*CELLPIXELS,PADDING_UP);
            rectangle.setColor(Color.CYAN);
            line = new Line(0,PADDING_UP,cols*CELLPIXELS,PADDING_UP);
            line.setColor(Color.BLACK);
        }
        if(road == true){
            rectangle = new Rectangle(0,PADDING_UP,cols*CELLPIXELS,rows*CELLPIXELS);
            rectangle.setColor(Color.DARK_GRAY);
            line = new Line(0,PADDING_UP+(2*CELLPIXELS),cols*CELLPIXELS,PADDING_UP+(2*CELLPIXELS));
            line.setColor(Color.WHITE);
        }

    }

    public void init(){
        rectangle.fill();
        line.draw();
    }

    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }

    public int getWidth() {
        return rectangle.getWidth();
    }

    public int getHeight() {
        return rectangle.getHeight();
    }

    public int getX() {
        return rectangle.getX();
    }

    public int getY() {
        return rectangle.getY();
    }

    public int getCellSize() {
        return CELLPIXELS;
    }

    public int rowToY(int row) {
        return row * CELLPIXELS;
    }

    public int columnToX(int column) {
        return column * CELLPIXELS;
    }

}
